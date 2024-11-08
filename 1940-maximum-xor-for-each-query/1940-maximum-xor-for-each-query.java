class Solution {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] ans = new int[nums.length];
     
      int xor =0;
        for(int i =0;i<nums.length;i++){
            xor = xor ^nums[i];
        }

        ans[0] = xor^(int)(Math.pow(2,maximumBit)-1);
        for(int i =1;i<nums.length;i++){
            ans[i] = ans[i-1]^nums[nums.length-i];
        }
        return ans;
       
        
    }
}