class Solution {
    public int waysToSplitArray(int[] arr) {

        int countingNumberOfSplits=0;
        long sumOfAllElements=0;

        //Calculating the sum of all the array
        for(int i:arr) {
            sumOfAllElements+=i;
        }

        long leftSum = 0;

        // Iterate through the array until the second last element
        for (int i = 0; i < arr.length - 1; i++) {
            leftSum += arr[i];
            long rightSum = sumOfAllElements - leftSum;

            // Check if the left sum is greater than or equal to the right sum
            if (leftSum >= rightSum) {
                countingNumberOfSplits++;
            }
        }


        return countingNumberOfSplits;
        
    }
}