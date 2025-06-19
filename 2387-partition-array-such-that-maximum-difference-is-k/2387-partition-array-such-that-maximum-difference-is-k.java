class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int l = 0;
        int r = 0;
        int checker = -1;

        while(r < nums.length){
            if(nums[r] - nums[l] <= k){
                r++;
            }else{
                l = r;
                ans++;
            }
        }
        return ans + 1;
    }
}