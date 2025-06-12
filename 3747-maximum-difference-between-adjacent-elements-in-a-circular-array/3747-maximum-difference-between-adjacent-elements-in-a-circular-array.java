class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxDifference=Integer.MIN_VALUE;
        if(nums.length > 2){
            maxDifference=Math.max(maxDifference, Math.abs(nums[0] - nums[nums.length-1]));
        }
        for(int i=0 ;i <nums.length-1; i++){

            maxDifference=Math.max(maxDifference, Math.abs(nums[i] - nums[i+1]));
        }

        return maxDifference;
        
        
    }
}