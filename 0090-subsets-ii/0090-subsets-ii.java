class Solution {

    void solve(int[] nums,Set<List<Integer>> res,  int index,List<Integer> output ){

        if(index>=nums.length){
            res.add(new ArrayList<>(output));
            return;
        }

        //exclude
        solve(nums, res, index+1, output);

        //include
        int number=nums[index];
        output.add(number);
        solve(nums, res, index+1, output);
        output.remove(output.size()-1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> list=new HashSet<>();
        int index=0;

        Arrays.sort(nums);  //Sort to handle duplicates

        solve(nums, list,index, new ArrayList<>());
        return new ArrayList<>(list);

    }
}