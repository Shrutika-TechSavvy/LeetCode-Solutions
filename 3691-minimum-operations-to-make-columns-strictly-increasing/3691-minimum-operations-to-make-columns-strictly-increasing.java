class Solution {
    public int minimumOperations(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        int totalOperations = 0;
        for (int col = 0; col < cols; col++) {
            for (int row = 1; row < rows; row++) {
                // If the current value is less than or equal to the value above it
                if (grid[row][col] <= grid[row - 1][col]) {
                    // Calculate the required increment
                    int increment = grid[row - 1][col] - grid[row][col] + 1;
                    grid[row][col] += increment; // Update the grid
                    totalOperations += increment; // Add to the total operations
                }
            }
        }

        return totalOperations;
    }
}