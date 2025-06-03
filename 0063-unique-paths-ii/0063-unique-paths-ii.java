class Solution {
    public int solve(int i, int j, int m, int n, int[][] grid, int dp[][]){
        if(i<m && j<n && grid[i][j]==1) return 0;//Obstacle
        //general base cases
        if(i>=m || j>=n) return 0;
        if(i== m-1 && j==n-1) return 1;

        if(dp[i][j]!=-1) return dp[i][j];
        int up=solve(i+1, j, m, n, grid, dp);
        int down=solve(i, j+1, m, n, grid, dp);
        
        return dp[i][j]=up+down;

    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];

        for(int a[]: dp){
            Arrays.fill(a, -1);
        }
        return solve(0, 0, m,n, grid, dp);
    }
}