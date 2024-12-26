class Solution {
    int totalWays = 0;

    public int findTargetSumWays(int[] nums, int target) {
        calculateWays(nums, 0, 0, target);
        return totalWays;
    }

    private void calculateWays(int arr[], int currIn, int currSum, int t){
        if(currIn == arr.length){
            // Check if the current sum matches the target
            if(currSum == t){
                totalWays++;
            }
        }
        else{
            // Include the current number with a positive sign
            calculateWays(arr, currIn + 1, currSum + arr[currIn], t);

            // Include the current number with a negative sign
            calculateWays(arr, currIn + 1, currSum - arr[currIn], t);
        }
    }
}