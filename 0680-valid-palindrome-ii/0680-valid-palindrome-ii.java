class Solution {
    public static boolean isPalindrome(String s){
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    public boolean validPalindrome(String s) {
        int left=0;
        int right= s.length()-1;
        while(left<=right){

            if(s.charAt(left) == s.charAt(right)){
            left++;
            right--;
            }
            else{
                boolean checkLeftCharacter=isPalindrome(s.substring(left, right));
                boolean checkRightCharacter=isPalindrome(s.substring(left+1, right+1));

                return checkLeftCharacter || checkRightCharacter;

            }
        }
        return true;
        
    }
}