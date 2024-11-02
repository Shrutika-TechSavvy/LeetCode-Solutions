class Solution {
    public boolean isCircularSentence(String sentence) {
       int n = sentence.length();
       for(int i=1;i<n-1;i++){
        if(sentence.charAt(i) == ' '){
            if(sentence.charAt(i-1) != sentence.charAt(i+1)){
                return false;
            }
        }
       } 
       if(sentence.charAt(n-1) == sentence.charAt(0)) return true;
       return false;
    }
}