class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int N=n*n;  //Total no. of elements

        int[] ans=new int[2];
        HashMap<Integer, Integer> map=new HashMap<>();

        int a=-1, b=-1;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n ;j++){
               int va=grid[i][j];
               if(map.containsKey(va)){
                ans[0]=va;
               }
               else{
                map.put(va, 1);
               }
            }
        }

        for(int i=1;i <=n*n ;i++){
            if(!map.containsKey(i)){
                ans[1]=i;
            }
        }

        return ans;

    }
}