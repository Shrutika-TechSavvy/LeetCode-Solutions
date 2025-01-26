class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;

        int leftSum=0;
        int totalSum=0;
        int count=0;

        for(int i=0; i<n; i++){
            totalSum+=nums[i];
        }

        for(int i=0;i <n-1; i++){
            leftSum+=nums[i];
            int rightSum=totalSum-leftSum;

            if((leftSum-rightSum)%2==0){
                count++;
            }
        }
        return count;
    }
}