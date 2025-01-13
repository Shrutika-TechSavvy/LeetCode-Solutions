class Solution {
    public int[][] merge(int[][] arr) {
        
        int n=arr.length;
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[0]-b[0];
            }
        });
        List <List<Integer>> ans=new ArrayList<>();

        for(int i=0; i<n; i++){

            //if teh current interval does not lies in last inetrval, new interval in answer
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }

            //if the current interval lies in the last interval, can be merged
            ans.get(ans.size()-1). set(1, Math.max(ans.get(ans.size()-1).get(1), arr[i][1]));

            /*Brute force approach
            int start=intervals[i][0];
            int end=intervals[i][1];

            if(!ans.isEmpty() && end<=ans.get(ans.size()-1).get(1))
            continue;

            for(int j=i+1; j<n ;j++){
                if(intervals[j][0] <=end){
                    end=Math.max(end, intervals[j][1]);
                }else{
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
            */
        }

        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }
        return result;

    }
}