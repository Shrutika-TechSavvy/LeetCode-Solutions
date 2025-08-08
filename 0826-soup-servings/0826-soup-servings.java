class Solution {
    public double soupServings(int n) {
        if (n >= 4800) return 1.0;  // Optimization: result approaches 1.0 for large n
        int units = (int) Math.ceil(n / 25.0);
        Double[][] memo = new Double[units + 1][units + 1];
        return dfs(units, units, memo);
    }

    private double dfs(int a, int b, Double[][] memo) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (memo[a][b] != null) return memo[a][b];

        memo[a][b] = 0.25 * (
            dfs(Math.max(a - 4, 0), b, memo) +
            dfs(Math.max(a - 3, 0), Math.max(b - 1, 0), memo) +
            dfs(Math.max(a - 2, 0), Math.max(b - 2, 0), memo) +
            dfs(Math.max(a - 1, 0), Math.max(b - 3, 0), memo)
        );

        return memo[a][b];
    }
}