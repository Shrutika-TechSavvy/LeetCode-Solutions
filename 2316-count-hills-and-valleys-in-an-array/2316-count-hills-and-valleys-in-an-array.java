class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        int lastN = nums[0];
        for(int i=1; i<nums.length-1; i++){
            if((nums[i] < lastN && nums[i] < nums[i+1]) || (nums[i] > lastN && nums[i] > nums[i+1])){
                ans++;
                lastN = nums[i];
            // System.out.println(i+" "+ans+" "+lastN);
            }
        }
        return ans;
    }
}