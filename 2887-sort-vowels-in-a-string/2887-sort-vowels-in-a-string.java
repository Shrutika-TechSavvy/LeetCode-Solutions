class Solution {
    public String sortVowels(String s) {
        List<Integer> vowelIndices = new ArrayList<>();
        List<Character> vowels = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                vowelIndices.add(i);
                vowels.add(c);
            }
        }

        vowels.sort(Comparator.comparingInt(a -> (int) a));
        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < vowelIndices.size(); i++) {
            result.setCharAt(vowelIndices.get(i), vowels.get(i));
        }
        return result.toString();
    }

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}