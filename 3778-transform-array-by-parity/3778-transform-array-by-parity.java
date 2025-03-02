class Solution {
    public int[] transformArray(int[] nums) {
        int countZero=0;
        int countOne=0;
        for(int i=0 ; i< nums.length ;i++){
            if(nums[i] % 2==0 ){
                //number is even , so replace it with the 0
                nums[i]=0;
                countZero++;
            }
            else if(nums[i ] % 2 != 0){
                //number is odd , so replace it with the 0
                nums[i]=1;
                countOne ++;
            }
        }
        
       //Arrays.sort(nums);
       int res[]=new int[nums.length];
       Arrays.fill(res, 0);
       int i=countZero;
       while(i<nums.length){
        res[i++] =1;

       }
    return res;
    }
}