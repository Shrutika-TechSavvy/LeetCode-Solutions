class Solution {
    int solve(int i, int j, int n, List<List<Integer>> t, int[][] dp){
        if(i>=n || j>=t.get(i).size()) return (int)(1e9);
        if(i==n-1) return t.get(i).get(j);

        if(dp[i][j] != -1)return dp[i][j];
        int down=t.get(i).get(j) + solve(i+1, j, n, t, dp);
        int diagonal=t.get(i).get(j) + solve(i+1, j+1, n, t, dp);
        return dp[i][j] =Math.min(down, diagonal);

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0,n, triangle, dp);
        
    }
}