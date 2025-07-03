class Solution {
    public char kthCharacter(int k) {
        StringBuilder word=new StringBuilder("a");
        
        while(word.length()<k)
        {
            StringBuilder newWord=new StringBuilder();
            for(int i=0;i<word.length();i++)
            {
                char newtChar=(char)((word.charAt(i)-'a'+1)%26+'a');
                newWord.append(newtChar);
                
            }
            word.append(newWord);
        }
        return word.charAt(k-1);
        
    }
}