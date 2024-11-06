class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums,n);
        for(int i=0; i < n-1 ; i++){
            if(arr[i]<=arr[i+1])
                continue;
            else{
                if(Integer.bitCount(nums[i])==Integer.bitCount(nums[i+1])  ){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
                else
                    return false;
            }
        }
        for(int i = n-1;i>=1;i--){
            if(arr[i]>=arr[i-1])
                continue;
            else{
                if(Integer.bitCount(nums[i])==Integer.bitCount(nums[i-1]) ){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
                else
                    return false;
            }
        }
        return true;
    }
}