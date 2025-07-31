class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        // Set to store all unique bitwise OR results of subarrays
        Set<Integer> result = new HashSet<>();
        
        // Set to store bitwise OR results of subarrays ending at the previous element
        Set<Integer> prev = new HashSet<>();
        
        // Iterate through each number in the input array
        for (int num : arr) {
            // Set to store bitwise OR results of subarrays ending at the current element
            Set<Integer> curr = new HashSet<>();
            
            // Add the current number itself as a subarray of length 1
            curr.add(num);
            
            // For each OR value from the previous subarrays,
            // compute the OR with the current number and add to curr
            for (int val : prev) {
                curr.add(val | num);
            }
            
            // Add all current OR results to the overall result set
            result.addAll(curr);
            
            // Update prev to be curr for the next iteration
            prev = curr;
        }
        
        // The size of result is the count of unique bitwise ORs of all subarrays
        return result.size();
    }
}