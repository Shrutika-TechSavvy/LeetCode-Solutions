class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int[][] dist=new int[n][m];
        Queue<int[]> q=new LinkedList<>();

        for( int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0 ){
                    q.offer(new int[]{i, j});
                }
                else{
                    dist[i][j] = -1;
                }
            }
        }

        int dr[]={0, 0, -1, 1};
        int dc[] ={1, -1, 0, 0};

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i=0; i<4 ;i++){
                int newrow = r + dr[i];
                int newcol = c + dc[i];

                if(newrow >= 0 && newcol >= 0 && newrow < n && newcol <m && dist[newrow][newcol] == -1){
                    dist[newrow][newcol] = dist [r][c] + 1;
                    q.offer(new int[]{newrow, newcol});
                }
            }
        }

        return dist;
    }
}