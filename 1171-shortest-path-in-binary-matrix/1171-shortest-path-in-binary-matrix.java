class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        int[] dr = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
        int[] dc = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
        distance[0][0] = 1;
        queue.offer(new int[] { 1, 0, 0 }); // dist, x, y
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int dist = curr[0];
            int x = curr[1];
            int y = curr[2];
            for (int i = 0; i < 8; i++) {
                int row = x + dr[i];
                int col = y + dc[i];
                if (row > -1 && row < m && col > -1 && col < n && grid[row][col] == 0) {
                    if (distance[row][col] > dist + 1) {
                        distance[row][col] = dist + 1;
                        queue.offer(new int[] { dist + 1, row, col });
                    }
                }
            }
        }
        if (distance[m - 1][n - 1] == Integer.MAX_VALUE)
            return -1;
        return distance[m - 1][n - 1];
    }
}