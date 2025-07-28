/*
Uisng the DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];

        // If the starting pixel already has the new color, no need to process
        if (iniColor == color) return image;

        int[][] ans = image;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};

        dfs(sr, sc, ans, image, dx, dy, color, iniColor);
        return ans;
    }

    void dfs(int row, int col, int[][] ans, int[][] image, int[] dx, int[] dy, int newColor, int iniColor) {
        ans[row][col] = newColor;

        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && image[nrow][ncol] == iniColor) {
                if (ans[nrow][ncol] != newColor) {
                    dfs(nrow, ncol, ans, image, dx, dy, newColor, iniColor);
                }
            }
        }
    }
}
*/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        if (image[sr][sc] == color) return image;


        int oldColor= image[sr][sc];
        int n = image.length;
        int m = image[0].length;

        q.offer(new int[]{sr, sc});   //initial node
        image[sr][sc] = color;  //  Color the starting point immediately


        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        while(!q.isEmpty()){
            int point[] = q.poll();
            int x = point[0];
            int y = point[1];

            for(int d = 0 ; d<4; d++){
                int newX = x + dx[d];
                int newY = y + dy[d];

                if(newX < 0 || newY < 0 || newX >= n || newY >= m || image[newX][newY] != oldColor){
                    continue;
                }
                else{
                    image[newX][newY] = color;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
        return image;
    }
}