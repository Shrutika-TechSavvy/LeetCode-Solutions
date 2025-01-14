class Solution {

    private void solve (int index, int candidates[], int target, List<Integer> output, List<List<Integer>> result){
        

        if(target < 0) return; //Means we are going in wrong direction


        //base condition
        if(target==0){
            result.add(new ArrayList<>(output));
            return ;

        }
        
        for(int i=index; i<candidates.length; i++){
            
            //Skipping the duplicates
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            output.add(candidates[i]);
            solve(i+1, candidates,target-candidates[i], output, result );
            output.remove(output.size()-1);

        }
    }
        /*
        //handling the recursion without the loop
        if(index< candidates.length){

            //Skipping the duplicate elements to avoid repeated combinations
            if(index >0 && candidates[index]==candidates[index-1] && output.isEmpty()){
                solve(index+1, candidates, target, output, result);  // direct go to next index 
                return ;
            }

            //Else include the current candidate as it is unique and can make the new combination
            output.add(candidates[index]);
            solve(index+1, candidates, target-candidates[index], output, result); //Recursive call to the next index
            output.remove(output.size()-1);

            //exclude the current candidate
            solve(index+1, candidates, target, output, result);
            */
        

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result=new ArrayList<>();
        int index=0;
        List<Integer> output=new ArrayList<>();
        Arrays.sort(candidates);
        solve(index, candidates, target, output, result );
        return result;
        
    }
}