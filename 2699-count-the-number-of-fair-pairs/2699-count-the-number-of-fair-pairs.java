class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
         int n=nums.length;

         Arrays.sort(nums);
         long ans=0;

        long ansLower = 0;
        long ansUpper = 0;
        // int n = nums.length;

        int i = 0, j = n - 1;
        while (i < j) {
            if (nums[i] + nums[j] >= lower) {
                ansLower += j - i;
                j--;
            } else {
                i++;
            }
        }

        i = 0; j = n - 1;
        while (i < j) {
            if (nums[i] + nums[j] >= upper + 1) {
                ansUpper += j - i;
                j--;
            } else {
                i++;
            }
        }

        ans=ansLower-ansUpper;
        return ans;

    }
}