class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;

        for(int i = 0; i < nums.length; i++){
            int minimum = Integer.MAX_VALUE;
            int maximum = Integer.MIN_VALUE;

            for(int j = i; j < nums.length; j++){

                minimum = Math.min(minimum, nums[j]);
                maximum = Math.max(maximum, nums[j]);
                int range = maximum - minimum ; 
                sum += (long)range;
            }
        }

        return sum;
    }
}