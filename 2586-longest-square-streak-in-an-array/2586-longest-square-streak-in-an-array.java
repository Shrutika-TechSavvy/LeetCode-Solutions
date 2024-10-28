class Solution {
    public int longestSquareStreak(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            int length = 0;
            long current = num;
            while (numSet.contains((int)current)) {
                length++;
                if(current * current >1e5){
                    break;
                }
                current = current * current; 
            }   
            maxLen = Math.max(maxLen, length);
        }
        return maxLen < 2 ? -1 : maxLen;
    }
}