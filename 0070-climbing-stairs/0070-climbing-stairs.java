class Solution {
    private int solve(int n, int[] dp){
        
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!=-1){
            return dp[n];
        }

        //else calculate the value of that n
        return dp[n]=solve(n-1, dp)+ solve(n-2,dp);

    }
    public int climbStairs(int n) {
       
       /*The recursive solution: TLE
        if(n==1 || n==0) return 1;
        int ans=climbStairs(n-2)+climbStairs(n-1);
        return ans;
        */

        //Trying the memoization
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n, dp);

    }
}