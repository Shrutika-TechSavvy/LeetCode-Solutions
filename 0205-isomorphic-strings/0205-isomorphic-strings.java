class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Condition: If both the strings don't have the same langth, it's not
        // isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Data structure preferred for mapping each character with each other is
        // HashMap
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Forward mapping check (s -> t)
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false;
                }
            } else {
                mapST.put(charS, charT);
            }

            // Reverse mapping check (t -> s)
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false;
                }
            } else {
                mapTS.put(charT, charS);
            }
        }
        return true;
    }
}