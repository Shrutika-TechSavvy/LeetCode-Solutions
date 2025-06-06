class Solution {
    public int repeatedStringMatch(String a, String b) {
        int d = 256; // Base for hash (ASCII)
        int q = 101; // Prime to avoid collisions

        int m = b.length();

        // Step 1: Repeat `a` until it's longer than `b`
        StringBuilder repeated = new StringBuilder(a);
        int count = 1;
        while (repeated.length() < b.length()) {
            repeated.append(a);
            count++;
        }

        // Try one more repetition (to cover overlaps)
        String repeatedStr = repeated.toString();
        if (rabinKarpSearch(repeatedStr, b, d, q)) return count;
        repeated.append(a);
        if (rabinKarpSearch(repeated.toString(), b, d, q)) return count + 1;

        return -1;
    }

    // Rabin-Karp substring search
    private boolean rabinKarpSearch(String text, String pattern, int d, int q) {
        int n = text.length();
        int m = pattern.length();
        int h = 1; // high order digit
        int p = 0; // hash of pattern
        int t = 0; // hash of text window

        // h = pow(d, m-1) % q
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Initial hash of pattern and first text window
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the window
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) break;
                }
                if (j == m) return true;
            }

            // Rolling hash: remove leading, add trailing
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) t += q;
            }
        }

        return false;
    }
}
