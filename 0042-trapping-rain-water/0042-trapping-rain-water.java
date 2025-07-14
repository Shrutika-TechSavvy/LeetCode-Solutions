class Solution {
    public int trap(int[] height) {
        /*
        Gives tle
        int result = 0;

        for(int i = 0; i<height.length; i++){
            int j = i;
             int leftMax =0, rightMax = 0;

            while( j >= 0 ){
                leftMax = Math.max(leftMax, height[j]);
                j--;
            }
            j=i;

            while(j<height.length){
                rightMax = Math.max(rightMax, height[j]);
                j++;
            }
            result +=Math.min(leftMax, rightMax) - height[i];
        }
        return result;
        */
        //optimized solution

        int res = 0;
        int n = height.length;
        int left = 0, right = n-1, maxLeft=0, maxRight =0;

        while(left <= right ){
            if(height[left] <= height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }
                else{
                    res += maxLeft-height[left];
                }
                left++;
            }
            else{
                if(height[right] >= maxRight){
                    maxRight = height[right];
                }
                else{
                    res+=maxRight - height[right];
                }
                right --;
            }
        }
        return res;
    }
}