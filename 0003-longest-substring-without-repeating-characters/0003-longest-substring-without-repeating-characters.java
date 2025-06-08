class Solution {
    public int lengthOfLongestSubstring(String s) {
        //brute force
        /*
        general traverse over the string , use hashset or hashmap to check if that character already exists ,
        if yes then  go to next iteration of i
        If not increment the j pointer and calculate /increment the maxlength again4
        
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count = 0;
            set.clear();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                } else {
                    set.add(c);
                    count++;
                }
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
         */

        int left=0, right=0, maxLen=0;
        HashSet<Character> set = new HashSet<>();
        while(right < s.length()){
            char c=s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLen=Math.max(maxLen, right - left +1);
            right++;
        }

        return maxLen;
    }
}