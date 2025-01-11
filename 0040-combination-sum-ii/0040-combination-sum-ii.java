class Solution {

    private void solve (int index, int candidates[], int target, List<Integer> output, List<List<Integer>> result){
        

        if(target < 0) return; //Means we are going in wrong direction


        //base condition
        if(target==0){
            result.add(new ArrayList<>(output));
            return ;

        }

        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            output.add(candidates[i]);
            solve(i+1, candidates,target-candidates[i], output, result );
            output.remove(output.size()-1);

        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result=new ArrayList<>();
        int index=0;
        List<Integer> output=new ArrayList<>();
        Arrays.sort(candidates);
        solve(index, candidates, target, output, result );
        return result;
        
    }
}