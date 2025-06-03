/*class Solution {
    int solve(int i, int j , int m, int n){
        //Base cases
        if(i>m || j>n) return 0;  //Out of bounds gaya toh
        if(i==m-1 && j==n-1) return 1;  //means we are at the end point

        //Do/Explore
        int down=solve(i+1, j, m, n);
        int right=solve(i, j+1, m, n);
        return down+right;
    }
    public int uniquePaths(int m, int n) { 
        /*
        The starting point is the grid[0][0], end point is  grid[m-1][n-1]
        Finding the total no. of unique paths, the grid is blank
        directions are down and right. (trying to do the recursion from (0, 0))
        

        return solve(0, 0, m,n);
    }
}
It gives the TLE
*/
class Solution{

    int solve(int i, int j, int m, int n, int[][] dp){
        if(i>=m || j>=n) return 0;  //Out of bounds gaya toh
        if(i==m-1 && j==n-1) return 1;  //means we are at the end point

        if(dp[i][j] !=-1) return dp[i][j];

        int down=solve(i+1, j, m, n, dp);
        int right=solve(i, j+1, m, n, dp);
        return dp[i][j]=down + right;
    }
    public int uniquePaths(int m, int n){
        //The previous solution gives us the TLE so optimizing by the memoization
        int dp[][]=new int[m][n];
        for(int arr[]: dp){
            Arrays.fill(arr, -1);
        }
        return solve(0, 0, m, n, dp);
    }
}