class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        //Approach of sliding window
        //for each pair, try for each from the array

        int count=0;

        for(int i=0; i<dominoes.length; i++){
            int[] iPair=dominoes[i];
            int a1=iPair[0];
            int b1=iPair[1];
            for(int j=i+1; j<dominoes.length; j++){
                int jPair[]=dominoes[j];
                int a=jPair[0];
                int b=jPair[1];

                if((a1==a && b1==b) || (a1==b && b1==a)) {
                    count++;
                }
            }
        }
        return count;
    }
}