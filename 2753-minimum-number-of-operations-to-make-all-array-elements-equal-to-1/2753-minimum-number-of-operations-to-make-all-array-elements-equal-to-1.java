class Solution {
    public int minOperations(int[] nums) {
        
        
        int ones=0,n=nums.length;
        for(int i=0; i<n;i++){
            if(nums[i]==1){
                ones++;
            }
        }
        if(ones>0){
            return n-ones;
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int g=nums[i];
            for(int j=i+1;j<n;j++){
                g=gcd(g,nums[j]);
                if(g==1){
                    min=Math.min(min,j-i+1);
                    break;
                }
            }
        }
        if(min==Integer.MAX_VALUE) return -1;
        return (n-1)+(min-1);
        
          
    }
     public static int gcd(int a, int b){
            if(b==0){
                return a;
            }
            return gcd(b,a%b);
        }
}