class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=1; i<n; i++){
            if(nums[i-1] == nums[i]){
                nums[i-1]=nums[i-1]*2;
                nums[i]=0;
            }
        }
        //Shifting the zeroes at the end
        int i=0, j=0;
        while(i<n){
            if(nums[i]!=0){
                nums[j]=nums[i]; 

                if(i!=j) nums[i]=0;
                j++;
            }
          i++;
        }
    return nums;
    }
}