class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            if (num == 1) {
                sum++;
            } else {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}