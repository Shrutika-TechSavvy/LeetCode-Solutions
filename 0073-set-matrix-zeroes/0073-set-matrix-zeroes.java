class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zero[][] = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    zero[i][j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(zero[i][j])
                {
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = 0;
                    }
                    for (int l = 0; l < matrix[0].length; l++) {
                        matrix[i][l] = 0;
                    }
                }
            }
        }
    }
}