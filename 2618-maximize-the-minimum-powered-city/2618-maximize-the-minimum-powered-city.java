class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] dp = new long[n];
        long currSum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        // ✅ Initial window for city 0 → range [0, r]
        for (int i = 0; i <= Math.min(r, n - 1); i++) {
            currSum += stations[i];
        }

        // ✅ Compute dp for city 0
        dp[0] = currSum;
        min = Math.min(min, currSum);
        max = Math.max(max, currSum);

        // ✅ Slide window for rest cities
        for (int i = 1; i < n; i++) {
            if (i - r - 1 >= 0) currSum -= stations[i - r - 1];  // remove leftmost
            if (i + r < n) currSum += stations[i + r];            // add new rightmost
            dp[i] = currSum;
            min = Math.min(min, currSum);
            max = Math.max(max, currSum);
        }

        long start = 0;
        long end = max + k;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            if (isSolve(dp, mid, k, r)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private static boolean isSolve(long[] dp, long mid, long k, int r) {
        int n = dp.length;
        long[] diff = new long[n + 1];
        long add = 0;

        for (int i = 0; i < n; i++) {
            add += diff[i];
            if (dp[i] + add < mid) {
                long need = mid - (dp[i] + add);
                if (need > k) return false;
                k -= need;
                add += need;
                if (i + 2 * r + 1 < diff.length) diff[i + 2 * r + 1] -= need;
            }
        }
        return true;
    }
}