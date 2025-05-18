class Solution {
    List<String> combinations = new ArrayList<>();
    Integer[][] memo;

    public int colorTheGrid(int m, int n) {
        help("", m);
        memo = new Integer[combinations.size()][n];

        int count = 0;
        for (int i = 0; i < combinations.size(); i++) {
            count = (count + solve(i, n - 1, m)) % 1_000_000_007;
        }

        return count;
    }

    public int solve(int prevState, int n, int m) {
        if (n == 0) return 1;
        if (memo[prevState][n] != null) return memo[prevState][n];

        int total = 0;
        String prev = combinations.get(prevState);

        for (int i = 0; i < combinations.size(); i++) {
            String curr = combinations.get(i);
            boolean valid = true;
            for (int j = 0; j < m; j++) {
                if (curr.charAt(j) == prev.charAt(j)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                total = (total + solve(i, n - 1, m)) % 1_000_000_007;
            }
        }

        return memo[prevState][n] = total;
    }

    public void help(String word, int m) {
        if (word.length() == m) {
            combinations.add(word);
            return;
        }

        for (int i = 0; i < 3; i++) {
            char nextChar = (char) ('a' + i); // using 'a', 'b', 'c' to represent 3 colors
            if (word.isEmpty() || word.charAt(word.length() - 1) != nextChar) {
                help(word + nextChar, m);
            }
        }
    }
}