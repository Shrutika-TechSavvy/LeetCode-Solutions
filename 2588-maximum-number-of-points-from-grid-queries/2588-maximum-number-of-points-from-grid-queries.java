class Solution 
{

    public int[] maxPoints(int[][] grid, int[] q) 
    {
        int row = grid.length;
        int col = grid[0].length;
        boolean vis[][] = new boolean[row][col];
        vis[0][0] = true;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int dirs[][] = {{1,0} , {-1,0} ,{0,-1} , {0,1}};

        int sq[][] = new int [q.length][2];
        for(int i=0;i<q.length;i++)
        {
            sq[i][0] = q[i];
            sq[i][1] = i;
        }
        Arrays.sort(sq , Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {grid[0][0] , 0 , 0});
        int points = 0;
        int ans[] = new int [q.length];
        for(int []q1 : sq)
        {
            int val = q1[0] , qidx = q1[1];
            while(!pq.isEmpty() && pq.peek()[0] < val)
            {
                int cell[] = pq.poll();
                int r = cell[1] , c = cell[2];
                points++;
                for(int d[] : dirs)
                {
                    int nr = r + d[0] , nc = c + d[1];
                    if(nr>=0 && nr<row && nc>=0 && nc<col && !vis[nr][nc])
                    {
                        pq.add(new int[] {grid[nr][nc] , nr , nc});
                        vis[nr][nc] = true;
                    }
                }
            }
            ans[qidx] = points;
        }
        return ans;
    }
}