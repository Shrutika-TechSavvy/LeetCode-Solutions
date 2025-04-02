/*class Solution {
    public long maximumTripletValue(int[] nums) {

       /*
        long maximum=0;

        for(int i=0;i-2<nums.length;i++){
            for(int j=i+1; j-1<nums.length; j++){
                for(int k=j+1; k<nums.length;k++){
                    long calc=(long)((nums[i] - nums[j]) * nums[k]);
                    maximum=Math.max(maximum, calc);
                }
            }
        }

        return maximum;
        


        // Approach-2 (Using prefix and suffix storage)
        // T.C : O(n)
        // S.C : O(n)

        int n=nums.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];

        for(int i=1; i<n; i++){
            leftMax[i]=Math.max(leftMax[i-1], nums[i-1]);
        }
        for(int i=n-2;i>=0; i--){
            rightMax[i]=Math.max(rightMax[i+1], nums[i+1]);
        }

        long result=0;
        for(int j=1; j<n-1; j++){
            result=Math.max(result, (long)(leftMax[j] - nums[j]) * rightMax[j]);
        }

        return result;
    }
}
*/
// Approach-3 (Keeping track of maxDiff and maxi)
// T.C : O(n)
// S.C : O(1)
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long result = 0;
        long maxDiff = 0;
        long maxi = 0;
        
        for (int k = 0; k < n; k++) {
            result = Math.max(result, maxDiff * nums[k]);
            maxDiff = Math.max(maxDiff, maxi - nums[k]);
            maxi = Math.max(maxi, nums[k]);
        }
        
        return result;
    }
}