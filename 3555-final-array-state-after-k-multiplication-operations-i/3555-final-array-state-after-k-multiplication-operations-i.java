class Solution {

    public static int findMinIndex(int nums[])
    {
        int minimum = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minimum) {  
                minimum = nums[i];
                index = i;  
            }
        }
        return index; 
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Basic approach


        for (int i = 0; i < k; i++) {
           int minIndex = findMinIndex(nums);  // Get the index of the minimum value
            nums[minIndex] *= multiplier;
        }
        return nums;
    }
}