class Solution {
    public boolean canJump(int[] nums) {
        //the problem is simply to know If I can reach to the end or not

        //if(nums[0] == 0) return false;

        int n = nums.length;
        if(n == 1) return true;
        int maxReach = 0;
        for(int i = 0 ; i < n ; i ++){
            if( i > maxReach ) return false;
            maxReach = Math.max(maxReach , i + nums[i]);
        }
        return true;
    }
}