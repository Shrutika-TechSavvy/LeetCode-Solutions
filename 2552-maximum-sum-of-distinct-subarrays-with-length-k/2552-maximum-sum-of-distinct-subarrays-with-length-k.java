class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0; 
        int j = 0; 
        long sum = 0;
        long max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        while (j < nums.length) {
            if (set.contains(nums[j])) {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            } else {
                set.add(nums[j]);
                sum += nums[j];

                if ((j - i + 1) < k) {
                    j++; 
                } else if (j - i + 1 == k) {
                    max = Math.max(max, sum); 
                    sum -= nums[i];
                    set.remove(nums[i]);
                    i++; 
                    j++;
                }
            }
        }

        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}