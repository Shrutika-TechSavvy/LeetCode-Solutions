class Solution {
    public int countSubarrays(int[] nums) {
        int count=0;
        int lengthOfArray=nums.length;
        float firstNum=0, thirdNum=0, midNum=0;
        float half=0;
        if(lengthOfArray==1 || lengthOfArray==2) return 0;
        
        
        if(nums.length==3)
        {
            firstNum=nums[0]   ;
            thirdNum=nums[2];
            midNum=nums[1];
            half=midNum/2;
            
            if(firstNum+thirdNum==half) return 1;
        }
        
        for(int i=0;i<lengthOfArray-2;i++)
        {
            int j=i+2;
            firstNum=nums[i];
            thirdNum=nums[j];
            midNum=nums[i+1];
            
            float sum=firstNum+thirdNum;
            half=midNum/2;
            
            if(sum==half) count=count+1;
        }
        
        return count;
    }
}