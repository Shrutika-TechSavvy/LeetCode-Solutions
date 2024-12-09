class Solution {
    public void reverseString(char[] s) {
        
        for(int left=0,right=s.length - 1;left<right;left++,right--)
        {
            s[left]^=s[right];
            s[right]^=s[left];
            s[left]^=s[right];
        }
        /*
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
           
        } */
    }
}