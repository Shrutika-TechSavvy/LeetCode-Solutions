class Solution {
    public int numberOfPairs(int[][] points) {
        int ans = 0;
        Arrays.sort(points, (a, b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        for (int i = 0; i < points.length; i++) {
            int[] alice = points[i];
            for (int j =i+1; j < points.length; j++) {
                int[] bob = points[j];
                if(alice[0]>bob[0] || alice[1]<bob[1])
                {
                    continue;
                }
                // check between boundry 
                boolean invalid=false;
                for(int k=i+1;k<j;k++)
                {
                    int[] temp=points[k];
                    if(temp[0]>=alice[0] && temp[1]<=alice[1] && temp[0]<=bob[0] && temp[1]>=bob[1])
                    {
                        invalid=true;
                        break;
                    }
                }
                if(!invalid) ans++;
            }
        }
        return ans;
    }
}