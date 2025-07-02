class Solution {
    public int possibleStringCount(String word, int k) {
        final int MOD = 1000000007;
        List<Integer> grps = getgrps(word);
        long t = 1;
        for (int g : grps)
            t = t * g % MOD;
        if (k <= grps.size())
            return (int) t;
        int n = grps.size();
        int[] dp = new int[k];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int g = grps.get(i);
            int[] newDp = new int[k];
            int w = 0;
            for (int j = i; j < k; j++) {
                newDp[j] = w;
                w = (w + dp[j]) % MOD;
                if (j >= g)
                    w = (w - dp[j - g] + MOD) % MOD;
            }
            dp = newDp;
        }
        long inv = 0;
        for (int x : dp)
            inv = (inv + x) % MOD;
        return (int) ((t - inv + MOD) % MOD);
    }

    private List<Integer> getgrps(String s) {
        List<Integer> g = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                cnt++;
            else {
                g.add(cnt);
                cnt = 1;
            }
        }
        g.add(cnt);
        return g;
    }
}