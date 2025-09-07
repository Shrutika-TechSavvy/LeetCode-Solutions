class Solution {
    public int[] sumZero(int n) {
        int[] a = new int[n];
        a[0] = 0;

        int val = 1;
        int idx = 0;

        while(idx + 1 < n){
            a[idx] = val;
            a[idx + 1] = -val;

            idx+=2;
            val++;
        }
        return a;
        
    }
}