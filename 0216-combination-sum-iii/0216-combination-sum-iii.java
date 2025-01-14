class Solution {

    public void solve(int index, int[] nums, int n, int k, List<List<Integer>> ans,List<Integer> output ){

        //BAse condition
        if(output.size()==k && n==0){
            ans.add(new ArrayList<>(output));
        }

        if(index >=nums.length|| output.size()>k || n<0){
            return ;

        }
        /*
        //exclude
        solve(index+1, nums, n , k, ans, output);

        //include
        output.add(nums[index]);
        n-=nums[index];
        solve(index+1 , nums, n, k, ans, output);
        output.remove(output.size()-1);

        */

        for (int i = index; i < nums.length; i++) {
            output.add(nums[i]);                           // Choose the number
            solve(i + 1, nums, n - nums[i], k, ans, output); // Move to the next index
            output.remove(output.size() - 1);              // Backtrack
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>  ans=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        int nums[]=new int[9];

        //For our convenience
        for(int i=0; i<9; i++){
            nums[i]=i+1;
        }
        solve(0, nums, n, k, ans, output);
        return ans;
    }
}