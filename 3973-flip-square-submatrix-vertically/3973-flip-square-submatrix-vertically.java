class Solution {

    public void swap(int a, int b){
        int temp = a;
        a = b;
        a =temp;
        
    }
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int left = x;
        int right = x + k -1;

        while(left <= right){
            //Swap the row-wise data 
            for(int i = y; i <= y+k-1; i++){
                int temp = grid[left][i] ;
                grid[left][i] = grid[right][i];
                grid[right][i] = temp;
                
            }
            left++;
            right--;
        }

        return grid;
    }
}