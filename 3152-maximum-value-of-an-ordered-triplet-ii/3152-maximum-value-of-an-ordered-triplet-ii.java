class Solution {
    public long maximumTripletValue(int[] nums) {
        long max=0,maxdiff=0,maxprod=0;
        for(int i=0;i<nums.length;i++){
            maxprod=Math.max(maxprod,(long)(maxdiff*nums[i]));
            maxdiff=Math.max(maxdiff,max-nums[i]);
            max=Math.max(max,nums[i]);
        }
        return maxprod>0?maxprod:0;
    }
}