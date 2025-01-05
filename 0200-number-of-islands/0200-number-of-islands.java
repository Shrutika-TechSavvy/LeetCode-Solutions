/*class Solution {
    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            // Check all 4 possible directions
            for (int d = 0; d < 4; d++) {
                int newX = x + dx[d];
                int newY = y + dy[d];

                // Check bounds and if the cell is part of the island
                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length &&
                        grid[newX][newY] == '1' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int countIslands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If unvisited land cell is found, perform BFS and count as a new island
                if (grid[i][j] == '1' && !visited[i][j]) {
                    countIslands++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return countIslands;
    }
}
*/


class Solution {
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        // Boundary check and water check
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || 
            grid[i][j] == '0' || visited[i][j]) {
            return; // Stop the recursion if out of bounds, water, or already visited
        }

        // Mark the current land cell as visited
        visited[i][j] = true;

        // Explore all 4 directions without dx and dy arrays
        dfs(grid, i + 1, j, visited); // Down
        dfs(grid, i - 1, j, visited); // Up
        dfs(grid, i, j + 1, visited); // Right
        dfs(grid, i, j - 1, visited); // Left
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int countIslands = 0;

        // Traverse the entire grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If land and not visited, start DFS
                if (grid[i][j] == '1' && !visited[i][j]) {
                    countIslands++;
                    dfs(grid, i, j, visited); // Explore the entire island
                }
            }
        }
        return countIslands;
    }
}
