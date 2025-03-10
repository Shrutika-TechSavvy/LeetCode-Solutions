class Solution {

    boolean canEat(int[] piles, int h, int k) {
        for (int pile : piles) {
            h -= (pile + k - 1) / k;
        }
        return h >= 0;

    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = 0;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, piles[i]);
        }

        while (low < high) {
            int mid = (low + high) / 2;
            if (canEat(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }
}