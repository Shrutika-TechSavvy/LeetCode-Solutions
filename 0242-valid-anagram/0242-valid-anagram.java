import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {

        //Chcking of the both length are sam or not.If not, then they are not anagrams
        if(s.length()!=t.length())
        {
            return false;
        }
        //Frequency array 
        int charCount[]=new int[26];

        //At last the frequency array should have all value equal to zero because 
        //if found in s,increment it and if found in t decrement it
        for(int i=0;i< s.length();i++)
        {
            charCount[s.charAt(i)-'a']++; //incremeting the character count in frequency array
            charCount[t.charAt(i)-'a']--; //Decremnting that in frquency arra
        }


//checking if any value if no-zero or nott.if found, the strings are not anagrams
        for(int count:charCount)
        {
            if(count!=0)
            {
                return false;
            }
        }
        return true;
    }
}