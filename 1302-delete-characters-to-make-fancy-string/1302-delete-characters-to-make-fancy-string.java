class Solution {
    public String makeFancyString(String s) {
        StringBuilder solution = new StringBuilder();

        char ch = 'A'; // String contains only lowercase chars
        int count = 1;
        for (char i : s.toCharArray()) {
            if (i == ch) {
                count += 1;
                if (count < 3) {
                    solution.append(i);
                }
            } else {
                ch = i;
                count = 1;
                solution.append(ch);
            }
        }

        return solution.toString();
    }
}