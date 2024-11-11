class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        boolean[] arr = new boolean[max+1];
        for(int i=0;i<arr.length;i++){
            arr[i] = true;
        }
        arr[1] = false;
        for(int i=2;i<=Math.sqrt(max+1);i++){
            if(arr[i]){
                for(int j=i*i ;j<=max;j+=i){
                    arr[j] = false;
                }
            }
        }
        int curr = 1;
        int i=0;
        while(i<nums.length){
            int diff = nums[i]-curr;
            if(diff<0){
                return false;
            }

            if(arr[diff] || diff ==0){
                i++;
                curr++;
            }else{
                curr++;
            }
        }
        return true;
    }
}