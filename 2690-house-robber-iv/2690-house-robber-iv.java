class Solution {
    
    public boolean possible(int[] nums, int k,int mid) {
        int i=0, count = 0;
        // iterate nums and skip nums[i] which are greater than number we are finding
        while(i < nums.length) {
            if(nums[i] <= mid) {
                count++;
                i += 2;
            }
            else
                i += 1;
        }

        return count >= k ? true : false;
    }
    public int minCapability(int[] nums, int k) { // TC = O(nlogm)
        
        int n = nums.length;
        // binary search on the answer between min and max of nums 

        int minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;
        for(int num: nums) {
            minNum = Math.min(num, minNum);
            maxNum = Math.max(num, maxNum);
        }

        int l = minNum, r = maxNum, ans = maxNum;

        while(l<=r) {

            int mid = l +(r-l)/2;

            if(possible(nums, k, mid)) {
                ans = Math.min(ans,mid);
                r = mid - 1;
            }
            else  
                l = mid + 1;
        }

        return ans;
    }
}