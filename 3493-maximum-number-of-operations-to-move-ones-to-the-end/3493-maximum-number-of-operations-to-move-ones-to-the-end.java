class Solution {
    public int maxOperations(String s) {
        int res = 0;
        int[] cnt = new int[2];
        int p = 1;
        int i = 0;
        int ch;
        do {
            ch = s.charAt(i) - '0';
            if (ch > p) {
                res += cnt[1];
                cnt[0] = 0;
            }
            ++cnt[ch];
            p = ch;
        } while (++i < s.length());
        return res + ((cnt[0] | -cnt[0]) >>> 31) * cnt[1]; 
    }
}