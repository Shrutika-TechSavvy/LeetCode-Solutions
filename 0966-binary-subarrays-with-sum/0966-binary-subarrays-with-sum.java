class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // return atMost(nums, goal) - atMost(nums, goal - 1);

        int count = 0,sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum=0;
            for (int j = i; j < nums.length; j++) {
                // Calculate the sum of the subarray nums[i...j]
                sum += nums[j];

                if(sum>goal) break;
                // Check if the sum equals the goal
                if (sum == goal) {
                    count++;
                }
            }
        }
        return count;
    }
    /*
     * private int atMost(int[] nums, int goal) {
     * int head, tail = 0, sum = 0, result = 0;
     * for (head = 0; head < nums.length; head++) {
     * sum += nums[head];
     * while (sum > goal && tail <= head) {
     * sum -= nums[tail];
     * tail++;
     * }
     * result += head - tail + 1;
     * }
     * return result;
     * }
     */
}