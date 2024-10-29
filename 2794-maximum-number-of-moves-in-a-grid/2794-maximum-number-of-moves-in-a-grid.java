class Solution {
    public int maxMoves(int[][] grid) {

        int numMoves = 0;
        for(int j = 1; j<grid[0].length; j++) {
            if(numMoves < j-1) {
                return numMoves;
            }
            for(int i = 0; i<grid.length; i++) {
                int curr = grid[i][j];
                int up = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                int prev = grid[i][j-1];
                if(i>0) {
                    up = grid[i-1][j-1];
                }
                if(i<grid.length-1) {
                    down = grid[i+1][j-1];
                }

                if(prev < curr || up < curr || down < curr) {
                    numMoves = j;
                } else {
                    grid[i][j] = Integer.MAX_VALUE;
                }
                
            }
        }

        return numMoves;
        
    }
}