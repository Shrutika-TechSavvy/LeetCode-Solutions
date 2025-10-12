class Solution {
    public int longestBalanced(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[arr[j] - 'a']++;

                if (isBalanced(freq)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    private boolean isBalanced(int[] freq) {
        int val = -1;
        for (int f : freq) {
            if (f > 0) {
                if (val == -1) val = f;
                else if (val != f) return false;
            }
        }
        return true;
    }
}
