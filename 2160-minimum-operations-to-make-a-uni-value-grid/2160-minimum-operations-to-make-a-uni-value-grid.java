class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid[0].length * grid.length;
        int arr[] = new int[n];
        int remainder = grid[0][0]%x;
        int c = 0;
        //flattening the grid
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j]%x==remainder)
                   arr[c++] = grid[i][j];
                else 
                  return -1;
            }
        }
          Arrays.sort(arr);
          int median = arr[arr.length/2];
          int minOps = 0;
          for(int i :  arr)
              minOps += Math.abs(median-i)/x;
        
          return minOps; 
    }
}