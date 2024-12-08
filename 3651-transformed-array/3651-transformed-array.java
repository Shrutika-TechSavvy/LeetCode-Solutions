class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        

        for(int i=0;i<n;i++)
        {
            if(nums[i]==0) result[i]=nums[i];
            else if(nums[i]>0)
            {
                int newIndex = (i + nums[i]) % n;
                result[i] = nums[newIndex];
            }
            else if(nums[i]<0)
            {
                int newIndex = (i +nums[i]%n + n) % n;
                result[i] = nums[newIndex];
            }
        }
        return result;
    }

    //return the integer array of same size that of the original size, Result array
    //Given array is cicular
    // if num[i] is positive, start from the current index i and move to the right of the array num[i] steps
}