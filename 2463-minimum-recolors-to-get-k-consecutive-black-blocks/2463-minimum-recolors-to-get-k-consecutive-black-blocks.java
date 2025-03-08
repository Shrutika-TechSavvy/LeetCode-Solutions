class Solution {
    public int minimumRecolors(String blocks, int k) {
        /*int count;
        int n=blocks.length();
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n-k+1; i++){
            count=0;

            for(int j=i ; j<k+i ;j++){
                if(blocks.charAt(j) == 'W'){
                    count++;
                }
            }
            min=Math.min(min, count);
        }

        return min;
        */

        //Optimal approach
        int operation = 0;
        int minOperation = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
               operation++; 
            }
        }
        minOperation=operation;

        for(int i=k; i<blocks.length() ;i++)  {
            if (blocks.charAt(i - k) == 'W') operation--;
            if (blocks.charAt(i) == 'W') operation++;

            minOperation = Math.min(minOperation, operation);
        }
        
        return minOperation;
    }
} 