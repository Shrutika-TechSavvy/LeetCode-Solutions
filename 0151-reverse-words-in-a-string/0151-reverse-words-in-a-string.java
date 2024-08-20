class Solution {
    public String reverseWords(String s) {
         String[] str = s.trim().split("\\s+");
            String out = "";
            for (int i = str.length - 1; i > 0; i--) {
                // Append the current word and a space to the output
                out += str[i] + " ";
              }
        return out + str[0];
    }
}