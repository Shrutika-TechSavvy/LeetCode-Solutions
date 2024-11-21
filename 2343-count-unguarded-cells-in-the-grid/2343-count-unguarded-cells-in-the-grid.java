class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int arr[][]=new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=1;
            }
        }
        int totalguards=guards.length;
        int totalwalls=walls.length;
        for(int i=0;i<totalguards;i++){
            int x=guards[i][0];
            int y=guards[i][1];
            arr[x][y]=0;
        }
         for(int i=0;i<totalwalls;i++){
            int x=walls[i][0];
            int y=walls[i][1];
            arr[x][y]=-1;
        }
        for(int i=0;i<totalguards;i++){
            
            int x=guards[i][0];
            int y=guards[i][1];
            int tempx=x;
            int tempy=y;
           while(++y<n && arr[x][y]!=-1){
            if(arr[x][y]==-1 || arr[x][y]==0) break;
           arr[x][y]=2;
           }
           y=tempy;
           while(--y>=0 && arr[x][y]!=-1){
            if(arr[x][y]==-1 || arr[x][y]==0) break;
            arr[x][y]=2;
           }
           y=tempy;
           while(++x<m && arr[x][y]!=-1){
            if(arr[x][y]==-1 || arr[x][y]==0) break;
            arr[x][y]=2;

           }
           x=tempx;
           while(--x>=0 && arr[x][y]!=-1){
            if(arr[x][y]==-1 || arr[x][y]==0) break;
            arr[x][y]=2;
           }
           x=tempx;
        }
        int backdoor=0;
       for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

               if(arr[i][j]==1){
                backdoor++;
               }

            }
        }
        return backdoor;
    }
}