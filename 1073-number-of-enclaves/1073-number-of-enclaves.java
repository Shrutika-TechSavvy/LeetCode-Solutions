class Solution {
    
    public  void dfs(int grid[][], int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0)
            return;

        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public int numEnclaves(int[][] grid) {
        /*int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            // First column
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            // Last column
            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }

        for(int i = 0;i<n;i++){
            // First row
            if(grid[0][i]==1){
                dfs(grid,0,i);
            }
            // Last row
            if(grid[m-1][i]==1){
                dfs(grid,m-1,i);
            }
        }
        int count = 0;
            for(int i = 0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j] == 1){
                        count++;
                    }
                }
            }
        return count;

        */

         Queue<Pair> q = new LinkedList<Pair>();
        int n = grid.length; 
        int m = grid[0].length; 
        int vis[][] = new int[n][m];
        // traverse boundary elements
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // first row, first col, last row, last col 
                if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    // if it is a land then store it in queue
                    if(grid[i][j] == 1) {
                        q.add(new Pair(i, j)); 
                        vis[i][j] = 1; 
                    }
                }
            }
        }
        
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, +0, -1}; 
        
        while(!q.isEmpty()) {
            int row = q.peek().first; 
            int col = q.peek().second; 
            q.remove(); 
            
            // traverses all 4 directions
            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i]; 
                // check for valid coordinates and for land cell
                if(nrow >=0 && nrow <n && ncol >=0 && ncol < m 
                && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1; 
                }
            }
            
        }
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // check for unvisited land cell
                if(grid[i][j] == 1 & vis[i][j] == 0) 
                    cnt++; 
            }
        }
        return cnt;
    }

class Pair {
    int first;
    int second; 
    public Pair(int first, int second) {
        this.first = first; 
        this.second = second; 
    }
}
}