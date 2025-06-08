class Solution {

    int solve(int i, int j, int n, int m, int matrix[][] , int dp[][]){
        //Base cases
        //1. Out of bounds
        if(j<0 || j>=m) return (int) Math.pow(10, 9);

        //2. if we have reached the last roe then return
        if( i == n-1 ) return matrix[i][j];
        //3. If already exists in the , return it's value
        if(dp[i][j]!=-1) return dp[i][j];

        int down = matrix[i][j] + solve(i + 1, j, n, m, matrix, dp);
        int downLeft = matrix[i][j] + solve(i + 1, j - 1, n, m, matrix, dp);
        int downRight = matrix[i][j] + solve(i + 1, j + 1, n, m, matrix, dp);


        return dp[i][j] = Math.min(down, Math.min(downLeft, downRight));
    }

    public int minFallingPathSum(int[][] matrix) {
       /* int n=matrix.length;  //No. of rows,
        int m=matrix[0].length;   //No. of columns

        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        //int maxi = Integer.MAX_VALUE;
        
        for(int j=0; j<m; j++){
            int ans = solve(0, j,n,  m, matrix, dp);
            maxi = Math.min(maxi, ans);
        }
        return maxi;
        
*/

        //Calculate the maximum path sum for each cell in the matric
        int n = matrix.length;

        // dp[i][j] will store the min path sum to reach cell (i, j)
        int[][] dp = new int[n][n];

        // Base case: first row in dp is the same as the matrix
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill the dp table row by row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i - 1][j];
                int leftDiag = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int rightDiag = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDiag, rightDiag));
            }
        }

        // Find the minimum value in the last row
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][j]);
        }

        return minPathSum;
    }
}