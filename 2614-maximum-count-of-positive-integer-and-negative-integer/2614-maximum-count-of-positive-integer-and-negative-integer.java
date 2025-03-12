class Solution {
    public int maximumCount(int[] nums) {
        int countNeg=0, countPos=0;

        for(int i=0; i<nums.length ; i++){
            if(nums[i] < 0) countNeg++;
            else if(nums[i] > 0) countPos++;
        }
        return Math.max(countNeg, countPos);
    }
}