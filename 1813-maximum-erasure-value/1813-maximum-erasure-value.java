class Solution {
    public int maximumUniqueSubarray(int[] nums) 
    {
        int n=nums.length,max=0;
        int l=0,c=0;
        Set<Integer> set=new HashSet<>();
        for(int r=0;r<n;r++)
        {
            while(!set.isEmpty() && set.contains(nums[r]))
            {
                set.remove(nums[l]);
                c-=nums[l];
                l++;
            }
            set.add(nums[r]);
            c+=nums[r];
            if(c>max)
             max=c;
        }
        return max;
    }
}