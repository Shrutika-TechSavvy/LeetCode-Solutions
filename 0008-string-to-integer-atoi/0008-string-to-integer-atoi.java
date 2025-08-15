class Solution {
    public int myAtoi(String s) {
        
        //1. trim the leading and trailing spaces
        s = s.trim();
        if(s.length() == 0) return 0;

        int i = 0;
        int sign =1;
        long result = 0;

        //handling sign
        if(s.charAt(i) == '+' || s.charAt(i) == '-') {
            if(s.charAt(i) == '-') sign = -1;
            i++;
        }
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            result = result * 10 + (s.charAt(i) - '0');

            //4. Clamp on overflow
            if(sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int)result * sign;
        

        
    }
}