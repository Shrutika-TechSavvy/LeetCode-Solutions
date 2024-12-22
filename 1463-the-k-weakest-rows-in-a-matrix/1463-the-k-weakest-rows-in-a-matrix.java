class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //Brute force approach

        int count=0;
        int m = mat.length; // Number of rows
        int n = mat[0].length; // Number of columns
        
        // Step 1: Count soldiers in each row
        int[][] rowCounts = new int[m][2]; // [soldierCount, rowIndex]
        for (int i = 0; i < m; i++) {
            int soldierCount = countSoldiers(mat[i]); // Count 1's in the row
            rowCounts[i][0] = soldierCount;
            rowCounts[i][1] = i; // Store the row index
        }

        // Step 2: Sort by soldier count, and by row index for ties
        Arrays.sort(rowCounts, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0]; // Sort by soldier count
            } else {
                return a[1] - b[1]; // Sort by row index for ties
            }
        });

        // Step 3: Extract the first k row indices
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rowCounts[i][1]; // Get the row index
        }

        return result;
    }

    // Helper function to count the number of 1's in a row
    private int countSoldiers(int[] row) {
        int count = 0;
        for (int val : row) {
            if (val == 1) {
                count++;
            } else {
                break; // Stop counting when 0 is encountered
            }
        }
        return count;

    }
}