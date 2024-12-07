class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int maximum=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(sum>maximum)
            maximum=sum;
            
            if(sum<0) sum=0;
        }
        return maximum;
    }
}