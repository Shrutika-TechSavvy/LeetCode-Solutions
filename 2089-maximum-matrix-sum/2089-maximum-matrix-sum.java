class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0, count = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0){
                    matrix[i][j] = Math.abs(matrix[i][j]);
                    count++;
                }
               
                min = Math.min(min,matrix[i][j]);
                sum += matrix[i][j];
            }
        }
        return count%2==0 ? sum : (sum - (2 * min));
    }
}