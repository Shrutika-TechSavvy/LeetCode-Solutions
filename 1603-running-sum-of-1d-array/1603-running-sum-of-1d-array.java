class Solution {
    public int[] runningSum(int[] nums) {
        //here we are supposed to return the prefix sum array
        int ans[]=new int[nums.length],sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            ans[i]=sum;
        }
        return ans;
    }
}