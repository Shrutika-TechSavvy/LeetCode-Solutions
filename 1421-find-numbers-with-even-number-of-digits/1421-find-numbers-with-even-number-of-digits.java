class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            // String s=Integer.toString(nums[i]);
            // if(s.length()%2==0) count++;

            int c=0;
            int n=nums[i];
            while(n>0){
                c++;
                n=n/10;
            }
            if(c%2==0) count++;
        }
        return count;
    }
}