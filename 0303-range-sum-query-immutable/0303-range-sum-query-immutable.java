class NumArray {
    int[] ans;

    public NumArray(int[] nums) {
        ans=new int[nums.length];
        int s=0; //Foe calculating the sum 
        for(int i=0;i<nums.length;i++)
        {
            s+=nums[i]; //sum with current number where i is pointing
            ans[i]=s; //sum to add in prefix sum array
        }
    }
    
    public int sumRange(int left, int right) {
        //In this function it us supposed to calculate the sum of Queries ie. left and right
        //just from prefix sum already calculated

        if(left==0) return ans[right];
        else return ans[right]- ans[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */