class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1)
            return 1;
        int max = 0;

        // Finding the largest element in array for indexing of prefix array
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int count[] = new int[max + 1];

        // inserting the range in array
        for (int num : nums) {
            count[Math.max(num - k, 0)]++;
            if (num + k + 1 <= max) {
                count[num + k + 1]--;
            }
        }

        // find max of prefix sum

        int curSum = 0, maxSum = 0;
        for (int c : count) {
            curSum += c;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;

    }
}