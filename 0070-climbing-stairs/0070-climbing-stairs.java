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

    private int solve(int idx, int n , int dp[]){
        // If you exactly reach step n → 1 way (a valid path)
        if (idx == n) return 1;

        // If you go beyond step n → 0 ways
        if (idx > n) return 0;

        if(dp[idx] != -1) return dp[idx];
        return dp[idx] = solve(idx + 1, n , dp) + solve(idx + 2, n, dp);

    }
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
        /*
        if(n == 1) return 1;
        int dp[]=new int[n+1];  
        Arrays.fill(dp,-1); 
        dp[0]=1; //way to stay at ground
        dp[1]=1;
        for(int i=2;i<=n;i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
        */
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, n, dp);

    }
}