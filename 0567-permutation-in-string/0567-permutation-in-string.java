class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        if (m > n) return false;  // If s1 is longer than s2, no permutation is possible.

        // Frequency arrays for s1 and the current window in s2
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Count frequency array for s1
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Initialize the first window of size m in s2
        for (int i = 0; i < m; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Slide the window over the string s2
        for (int i = 0; i <= n - m; i++) {
            // If frequencies match, we found a valid permutation
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }

            // Slide the window to the right:
            if (i + m < n) {
                // Remove the first character of the current window
                windowFreq[s2.charAt(i) - 'a']--;
                // Add the next character to the window
                windowFreq[s2.charAt(i + m) - 'a']++;
            }
        }

        // Check the last window
        return Arrays.equals(s1Freq, windowFreq);
    }
}