class Solution {

    void dfs(int row, int col, int[][] visited, char mat[][], int dx[], int dy[]){
        visited[row][col] = 1; 
        int n = mat.length;
        int m = mat[0].length;

        //check for top, right, bottom, left
        for(int i=0; i<4; i++){
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            //Checked for valid coordinate and unvisited o'cs;
            if(nrow >= 0 && ncol >=0 && ncol<m && nrow<n && visited[nrow][ncol] == 0 && mat[nrow][ncol] == 'O'){
                dfs(nrow, ncol, visited, mat, dx, dy);
            }
            
        }

    }
    public void solve(char[][] mat) {

        int n=mat.length;
        int m=mat[0].length;
        int delrow[]={0, 0, 1, -1};
        int delcol[]={-1, 1, 0, 0};
        int visited[][]=new int[n][m];

        //traverse te first row and last row
        for(int j=0; j<m; j++){
            //first row
            if(visited[0][j] == 0 && mat[0][j] == 'O'){
                dfs(0, j, visited, mat, delrow, delcol);
            }

            //last row
            if(visited[n-1][j] == 0 && mat[n-1][j] == 'O'){
                dfs(n-1, j, visited, mat, delrow, delcol);
            }
        }
        for(int i=0; i<n; i++){
            //first column
            if(visited[i][0] == 0 && mat[i][0] == 'O'){
                dfs(i, 0, visited, mat, delrow, delcol);
            }

            //last column
            if(visited[i][m-1] == 0 && mat[i][m-1] == 'O'){
                dfs(i, m-1, visited, mat, delrow, delcol);
            }
        }

        //if unvisited o then convert them to X;
         for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                if(visited[i][j] == 0 && mat[i][j] == 'O') 
                    mat[i][j] = 'X'; 
            }
        }
}
}