class Solution {

     class Pair {
        int row;
        int col;
        int time;

        // Constructor to initialize row and column only
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        // Constructor to initialize row, column, and time
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair> q=new LinkedList<>();   // Queue to perform BFS

        int [][] visited=new int[n][m];
        int countFresh=0;  // Counter to count fresh oranges


        // Traverse the grid to initialize the queue and count fresh oranges
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {

                if(grid[i][j]==2)   // If the cell contains a rotten orange
                {
                    q.add(new Pair(i,j,0));   //add the rotten orange's position and time to the queue
                    visited[i][j]=0;   // Mark it as visited (already rotten)
                }
                else{
                    visited[i][j]=0;     // Mark as unvisited (either fresh or empty)
                }

                if(grid[i][j]==1) countFresh++;    // Count the number of fresh oranges
            }
        }

        int tm=0;   // To track the total time to rot all oranges
        int drow[]={-1,0,+1,0};   // Row direction array for up, down, left, right traversal
        int dcol[]={0,1,0,-1};      // Column direction array for up, down, left, right traversal

        int count=0;   // Counter to count the oranges that have become rotten during the process


         // Perform BFS to spread the rotting effect
        while(!q.isEmpty())   // While there are elements in the queue
        {
            int r=q.peek().row;   // Get the row of the current orange
            int c=q.peek().col;  // Get the column of the current orange
            int t=q.peek().time;  // Get the time when this orange became rotten

            q.remove();
            tm=Math.max(tm,t);  // Update the maximum time taken

            //traverse in all directions
            for(int i=0;i<4;i++)
            {
                int nrow=r+drow[i];
                int ncol=c+dcol[i];

                //checking if the new position is valid and contains the fresh prange
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
                    && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){

                        //if valid, , now add the fresh orange to queue with updated time
                        q.add(new Pair(nrow, ncol, t+1));    // Add the fresh orange to the queue with updated time
                        visited[nrow][ncol]=2;  //mark it as visited (now rotten)
                        count++;
                }
            }
        }

        if (count != countFresh) return -1;  //initial fresh all will be rotten

        return tm;
        
    }
}