class Solution {
    public int singleNumber(int[] nums) {
        int element=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            element^=nums[i];
        }
        return element;
    }
}