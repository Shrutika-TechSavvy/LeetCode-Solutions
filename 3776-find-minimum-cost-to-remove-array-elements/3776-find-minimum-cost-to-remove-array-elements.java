class Solution {
    int solve(int prevIdx, int idx, int[] nums, int[][] dp){

        //Base condition
        if(idx==nums.length) return nums[prevIdx];
        if(idx==nums.length-1) return Math.max(nums[prevIdx], nums[idx]);

        if(dp[idx][prevIdx] !=-1) return dp[idx][prevIdx] ;


        int op1=Math.max(nums[idx], nums[idx+1]) + solve(prevIdx, idx+2, nums, dp);
        int op2=Math.max(nums[prevIdx], nums[idx+1]) + solve(idx, idx+2, nums, dp);
        int op3=Math.max(nums[prevIdx], nums[idx]) + solve(idx+1, idx+2, nums, dp);

        return dp[idx][prevIdx]=Math.min(Math.min(op1, op2), op3);
    }
    public int minCost(int[] nums) {
        
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=0; i<dp.length ;i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,  1, nums, dp);
    }
}