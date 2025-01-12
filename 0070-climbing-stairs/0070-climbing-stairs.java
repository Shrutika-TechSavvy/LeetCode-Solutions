class Solution {
    
    /*For memoization
    private int solve(int n, int[] dp){
        
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!=-1){
            return dp[n];
        }

        //else calculate the value of that n
        return dp[n]=solve(n-1, dp)+ solve(n-2,dp);

    }
    */
    public int climbStairs(int n) {
       
       /*The recursive solution: TLE
        if(n==1 || n==0) return 1;
        int ans=climbStairs(n-2)+climbStairs(n-1);
        return ans;
        */

        //Trying the memoization
        /*int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n, dp);
        */

        //trying out the tabulation method

        if(n == 1) return 1;
        int dp[]=new int[n+1];  
        Arrays.fill(dp,-1); 
        dp[0]=1; //way to stay at ground
        dp[1]=1;
        for(int i=2;i<=n;i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}