class Solution {
    public int solve(int i, int j, int m ,int n, int[][] grid, int dp[][]){
        if(i>=m || j>=n) return (int) Math.pow(10, 9);
        if( i==m-1 && j==n-1) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];

        //Do/Explore
        int down=grid[i][j]+solve(i+1 , j, m, n, grid, dp);
        int right=grid[i][j]+ solve(i, j+1, m, n, grid, dp);


        return dp[i][j]=Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        //Given is the grid having the non-negative integers
        //m*n size
        //We want the path such that it will have the minimum sum of all numbers
        //Given directions: down and right
        //As always the greedy approach fails here. LOL
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];

        for(int arr[]: dp){
            Arrays.fill(arr, -1);
        }
        return solve(0, 0, m, n, grid, dp);

    }
}