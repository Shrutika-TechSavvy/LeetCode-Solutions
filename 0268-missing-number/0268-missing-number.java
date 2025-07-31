class Solution {
    public int missingNumber(int[] nums) {
        //SImply calculate the sum of n natural numbers
        //iterate through the array and find the sum of all available numbers
        //return sum of n natural no. - sum of all available no. 

        //This is one of the optimal approach 

        /*
        int n=nums.length;
        int sum_of_all_n_numbers=n*(n+1)/2;
        int sum_of_no_array=0;

        for(int i=0;i<nums.length;i++)
        {
            sum_of_no_array+=nums[i];
        }
        return sum_of_all_n_numbers - sum_of_no_array;

        */

        //Optimal appraoch 2
        //Preferred
        int xor1 = 0, xor2 = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            xor2 = xor2 ^ nums[i];
            xor1 = xor1 ^ (i+1);
        }
        //xor1 = xor1 ^ n;

        return (xor1 ^ xor2);

    }
}