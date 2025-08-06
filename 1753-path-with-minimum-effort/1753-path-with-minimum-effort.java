class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0] . length;
        
        int dist[][] = new int[n][m];

        for(int []row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] =0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            int top[]= pq.poll();
            int effort = top[0];
            int x = top[1];
            int y = top[2];

            if( x == n-1 && y == m-1) return effort;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0&& ny < m){
                    int newEffort = Math.max(effort, Math.abs(heights[nx][ny] - heights[x][y]));
                    if(newEffort < dist[nx][ny]){
                        dist[nx][ny] = newEffort;
                        pq.offer(new int[]{newEffort, nx, ny});
                    }
                }
            }
        }
        return 0;
    }
}