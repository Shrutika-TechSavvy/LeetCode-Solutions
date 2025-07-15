class Solution {
    public boolean isValid(String word) {
        //Approach : 
        /*
        Condition 1: word.length>=3
        Condition 2: Only digits(0-9), English letters both uppercase and lowercase
        Condition 3: Atleast one vowel
        Condition 4: Atleast one consonant
         */

        // Condition 1: Length must be at least 3
        if (word.length() < 3) return false;

        // Vowels set (includes both lowercase and uppercase)
        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a','e','i','o','u','A','E','I','O','U'
        ));

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            // Condition 2: Only letters and digits
            if (!Character.isLetterOrDigit(c)) return false;

            // Condition 3 & 4: At least one vowel and one consonant
            if (vowels.contains(c)) {
                hasVowel = true;
            } else if (Character.isLetter(c)) {
                hasConsonant = true;
            }
        }

        return hasVowel && hasConsonant;
    }
}
