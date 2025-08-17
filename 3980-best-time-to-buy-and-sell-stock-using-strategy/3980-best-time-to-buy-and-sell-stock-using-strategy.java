class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long baseProfit = 0;
        long[] contrib = new long[n];
        
        for (int i = 0; i < n; i++) {
            contrib[i] = (long) strategy[i] * prices[i];
            baseProfit += contrib[i];
        }

        long maxGain = Long.MIN_VALUE;
        long currentGain = 0;

        // Initial window [0..k-1]
        for (int i = 0; i < k/2; i++) currentGain += -contrib[i];
        for (int i = k/2; i < k; i++) currentGain += (long) prices[i] - contrib[i];
        maxGain = Math.max(maxGain, currentGain);

        // Slide the window
        for (int start = 1; start + k <= n; start++) {
            int end = start + k - 1;

            // Remove old left-half contribution
            currentGain -= -contrib[start - 1];

            // Remove old right-half contribution
            currentGain -= ((long) prices[start - 1 + k/2] - contrib[start - 1 + k/2]);

            // Add new left-half element
            currentGain += -contrib[start + k/2 - 1];

            // Add new right-half element
            currentGain += (long) prices[end] - contrib[end];

            maxGain = Math.max(maxGain, currentGain);
        }

        return baseProfit + Math.max(0, maxGain);
    }
}