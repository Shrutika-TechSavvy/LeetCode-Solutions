class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       int i = 0, j = 0;
    boolean re = false;
    int[] ans = new int[nums.length];

    while (i < nums.length) {
        if (nums[i] < pivot) {
            ans[j++] = nums[i];
        }
        i++;
    }

    i = 0; 
    while (i < nums.length) {
        if (nums[i] == pivot) {
            ans[j++] = nums[i];
            re = true;
        }
        i++;
    }

    i = 0; 
    while (i < nums.length) {
        if (re && nums[i] > pivot) {
            ans[j++] = nums[i];
        }
        i++;
    }

    return ans;
    }
}