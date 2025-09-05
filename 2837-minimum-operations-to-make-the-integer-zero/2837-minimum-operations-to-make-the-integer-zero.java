class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long target = num1 - 1L * k * num2;
            if (target < 0) continue; 

            long setBits = Long.bitCount(target);
            if (setBits <= k && k <= target) {
                return k;
            }
        }
        return -1;
    }
}