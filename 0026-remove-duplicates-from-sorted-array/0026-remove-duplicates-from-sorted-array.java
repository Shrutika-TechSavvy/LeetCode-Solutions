class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int j = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(! set.contains(nums[i])){
                arr.add(nums[i]);
                set.add(nums[i]);
                nums[j] = nums[i];
                j++;
            }
        }
        return arr.size();
    }
}