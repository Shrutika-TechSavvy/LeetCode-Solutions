class Solution {
    public int pivotIndex(int[] nums) {

        int rightSum= 0;
        int n = nums.length;

        for(int i = 0 ; i < n; i++){
            rightSum += nums[i];
        }

        //Actual logic
        int leftSum = 0;
        for(int i = 0; i < n ; i++){
            rightSum = rightSum - nums[i];
            if( leftSum == rightSum ) return i;
            else leftSum = leftSum  + nums[i];
        }

        return -1;
        
    }
}