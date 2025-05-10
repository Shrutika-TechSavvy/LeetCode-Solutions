class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;
        for(int x : nums1) {
            sum1 += Math.max(1, x);
            if(x == 0) zero1++;
        }
        for(int x : nums2) {
            sum2 += Math.max(1, x);
            if(x == 0) zero2++;
        }
        if(sum1 < sum2 && zero1 == 0 || sum1 > sum2 && zero2 == 0) return -1;
        return Math.max(sum1, sum2);
    }
}