
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sc = new StringBuilder();

        Arrays.sort(strs);
        String str1 = strs[0]; //1st string in array
        String str2 = strs[strs.length-1]; //last string in array
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if(str1.charAt(i)!=str2.charAt(i)) //If the characters at the ith position are not same, means common is ended
            {
                break; //so break out of loop
            }
            else sc.append(str1.charAt(i)); //if characters in both the strings are same ie. common it's added
        }
            return sc.toString();
    
    }
}