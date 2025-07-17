class Solution {
    public int maximumLength(int[] nums, int k) {
        int arr[][] = new int[k][k], max = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < k; j++)
                max = Math.max(max, arr[nums[i] % k][j] = arr[j][nums[i] % k] + 1);
        return max;
    }
}