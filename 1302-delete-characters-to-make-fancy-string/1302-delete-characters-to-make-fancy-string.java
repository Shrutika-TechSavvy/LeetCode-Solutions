class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int n = s.length();int count = 1;
        for(int i = 1 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == s.charAt(i - 1) ){
                count++;
            }
            else{
                //the previous character and the current one is not same
                count = 1;
            }
            if(count >= 3) continue;
            sb.append(ch);
        }
        return sb.toString();
    }
}