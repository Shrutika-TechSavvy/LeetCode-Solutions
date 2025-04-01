class Solution {
    public long mostPoints(int[][] questions) {
        int length = questions.length;
        long[] dp = new long[length];

        dp[length - 1] = questions[length - 1][0];

        for (int i = length - 2; i >= 0; i--) {
            int index = i + questions[i][1] + 1;
            long points = questions[i][0] + (index >= length ? 0 : dp[index]);

            dp[i] = Math.max(dp[i + 1], points);
        }

        return dp[0];
    }
}