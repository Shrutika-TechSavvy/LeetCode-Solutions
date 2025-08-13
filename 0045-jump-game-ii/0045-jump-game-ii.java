class Solution {

    public static int minJumps(int index, int nums[], int jumps, int dp[]){
        //Base case
        //If u can reac beyond the array length
        if(index >= nums.length - 1) return jumps;
        if(dp[index] != -1) return dp[index] + jumps;

        int mini = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[index] ; i++){
            mini = Math.min(mini, minJumps(index + i, nums, jumps + 1, dp));
        }

        dp[index] = mini - jumps;
        return mini;
    }
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return minJumps(0,nums, 0, dp);
        
    }
}