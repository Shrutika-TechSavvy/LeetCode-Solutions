class Solution {
    public int maxFreqSum(String s) {
        int[] freq=new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        //Define goals
        String vowels="aeiou";
        int maxVowelFreq=0;
        int maxConstFreq=0;

        for(int i=0; i<26; i++){
            char ch=(char) (i+'a');
            if(vowels.indexOf(ch)>=0){
                maxVowelFreq=Math.max(maxVowelFreq, freq[i]);
            }
            else{
                maxConstFreq=Math.max(maxConstFreq, freq[i]);
            }
        }
        return maxVowelFreq + maxConstFreq;
    }
}