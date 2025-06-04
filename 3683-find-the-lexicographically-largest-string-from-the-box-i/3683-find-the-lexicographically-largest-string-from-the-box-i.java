class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            // Only one friend? The whole word is the answer!
            return word;
        }
        int n = word.length();

        // If numFriends > n, it's invalid (but per constraints, this won't happen)
        if (numFriends > n) {
            return ""; // Or throw an error
        }

        String result = ""; // Start with an empty string

        // The longest possible substring a friend can get
        int maxLengthAllowed = n - (numFriends - 1);

        // Slide a window of size up to maxLengthAllowed across the string
        for (int i = 0; i < n; i++) {
            int currentSubstringLength = Math.min(maxLengthAllowed, n - i);

            if (currentSubstringLength <= 0) {
                break; // No more valid substrings
            }

            String currentSubstring = word.substring(i, i + currentSubstringLength);

            // Is this substring bigger than our current best?
            if (currentSubstring.compareTo(result) > 0) {
                result = currentSubstring;
            }
        }
        return result;
    }
}