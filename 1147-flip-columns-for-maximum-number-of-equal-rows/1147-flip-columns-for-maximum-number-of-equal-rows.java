class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String , Integer> rows = new HashMap<>();
            
            for (int[] row : matrix) {
            StringBuilder str = new StringBuilder();
            for (int cell : row) {
                if (row[0] == 0) {
                    str.append(cell);
                } else {
                    str.append(1 - cell); 
                }
            }
            
            String key = str.toString();
            rows.put(key, rows.getOrDefault(key, 0) + 1);
        }

  
        int maxRows = 0;
        for (int count : rows.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    } 
    }