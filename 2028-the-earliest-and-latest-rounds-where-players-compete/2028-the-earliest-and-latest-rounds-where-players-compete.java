class Solution {
    int rMin = 6, rMax = 1;
    boolean[][][] dp = new boolean[6][28][29];

    void f(int round, int l, int r, int n) {
        if (dp[round][l][r]) return;
        dp[round][l][r] = true;

        if (l > r) {
            f(round, r, l, n);
            return;
        }

        if (l == r) {
            rMin = Math.min(rMin, round);
            rMax = Math.max(rMax, round);
            return;
        }

        int half = (n + 1) / 2;
        int iN = Math.min(l, half);

        for (int i = 1; i <= iN; i++) {
            int j0 = Math.max(l - i + 1, 1);
            for (int j = Math.min(half, r) - i; j >= j0; j--) {
                if (l + r - (i + j) <= n / 2) {
                    f(round + 1, i, j, half);
                }
            }
        }
    }

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        f(1, firstPlayer, n + 1 - secondPlayer, n);
        return new int[]{rMin, rMax};
    }
}