class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
          int[] results = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            // Extract the subarray of size k
            int[] subarray = Arrays.copyOfRange(nums, i, i + k);
            
            // Check if the subarray is sorted in ascending order
            boolean isSortedAndConsecutive = true;
            
            for (int j = 1; j < k; j++) {
                // If elements are not consecutive or not sorted, mark as invalid
                if (subarray[j] != subarray[j - 1] + 1) {
                    isSortedAndConsecutive = false;
                    break;
                }
            }
            
            // If valid, take the maximum element; otherwise, set to -1
            if (isSortedAndConsecutive) {
                results[i] = subarray[k - 1];
            } else {
                results[i] = -1;
            }
        }
        
        return results;
    }
}