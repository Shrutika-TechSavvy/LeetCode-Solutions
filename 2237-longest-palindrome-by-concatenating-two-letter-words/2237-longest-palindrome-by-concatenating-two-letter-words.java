class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> sameFreq = new HashMap<>();
        Map<String, Integer> diffFreq = new HashMap<>();
        for (String word : words) {
            if (word.charAt(0) == word.charAt(1)) {
                sameFreq.put(word, sameFreq.getOrDefault(word, 0) + 1);
            } else {
                diffFreq.put(word, diffFreq.getOrDefault(word, 0) + 1);
            }
        }

        int length = 0;
        boolean hasCenter = false;

        // Process same character words (like "aa", "bb")
        for (Map.Entry<String, Integer> entry : sameFreq.entrySet()) {
            int count = entry.getValue();
            if (count % 2 == 0) {
                length += count * 2;
            } else {
                length += (count - 1) * 2;
                hasCenter = true; // one can go in the middle
            }
        }

        // Process reverse pairs (like "ab" and "ba")
        Set<String> used = new HashSet<>();
        for (Map.Entry<String, Integer> entry : diffFreq.entrySet()) {
            String word = entry.getKey();
            String rev = "" + word.charAt(1) + word.charAt(0);
            if (diffFreq.containsKey(rev) && !used.contains(word) && !used.contains(rev)) {
                int pairs = Math.min(diffFreq.get(word), diffFreq.get(rev));
                length += pairs * 4;
                used.add(word);
                used.add(rev);
            }
        }

        if (hasCenter) length += 2; // one palindromic word can be in the center

        return length;
    }
}