class Solution {
    public int maximumCandies(int[] candies, long k) {
        long left = 1, right = 0;
        
        // Find the maximum pile size
        for (int candy : candies) {
            right = Math.max(right, candy);
        }

        int result = 0;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canDistribute(candies, k, mid)) {
                result = (int) mid; // Update result
                left = mid + 1; // Try to increase the amount per child
            } else {
                right = mid - 1; // Reduce the amount per child
            }
        }
        
        return result;
    }

    private boolean canDistribute(int[] candies, long k, long perChild) {
        if (perChild == 0) return false;
        
        long count = 0;
        
        for (int candy : candies) {
            count += candy / perChild;
        }
        
        return count >= k;
    }
}