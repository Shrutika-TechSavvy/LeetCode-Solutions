class Solution {
    private boolean hasZero(int x){
        return String.valueOf(x).indexOf('0') >= 0;
    }
    public int[] getNoZeroIntegers(int n) {
        int ans[] = new int[2];
        int a , b;

        if( n % 2 == 0){
            a = n / 2;
            b = n / 2;
        }
        else{
            a = (n + 1) / 2;
            b = (n - 1) / 2;
        }

        while(hasZero(a) || hasZero(b)){
            a --;
            b ++;
        }

        return new int[]{a, b};
    }
}