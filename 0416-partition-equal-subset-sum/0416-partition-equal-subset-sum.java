class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the total sum is odd, we cannot partition it into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // A sum of 0 can always be formed
        
        // Iterate through each number in the array
        for (int num : nums) {
            // Update the dp array from back to front
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        // The answer is whether we can form the target sum
        return dp[target];
    }
}