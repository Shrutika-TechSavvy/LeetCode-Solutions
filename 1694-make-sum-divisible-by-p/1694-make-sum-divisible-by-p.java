class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        // Step 1: Calculate the total sum modulo p
        int totalSumMod = 0;
        for (int num : nums) {
            totalSumMod = (totalSumMod + num) % p;
        }
        
        // If the sum is already divisible by p, return 0
        if (totalSumMod == 0) return 0;
        
        // Step 2: We need to find the smallest subarray with sum modulo p equal to totalSumMod
        HashMap<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1);  // To handle cases where the subarray starts from the beginning
        int currentPrefixMod = 0, minLength = n;
        
        for (int i = 0; i < n; i++) {
            currentPrefixMod = (currentPrefixMod + nums[i]) % p;
            int targetMod = (currentPrefixMod - totalSumMod + p) % p;
            
            if (prefixModMap.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - prefixModMap.get(targetMod));
            }
            // Update the map with the current prefix mod
            prefixModMap.put(currentPrefixMod, i);
        }
        
        // If we found a valid subarray, return its length, otherwise return -1
        return minLength == n ? -1 : minLength;
    }
}