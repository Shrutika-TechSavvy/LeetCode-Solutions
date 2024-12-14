class Solution {
    public int missingNumber(int[] nums) {
        //SImply calculate the sum of n natural numbers
        //iterate through the array and find the sum of all available numbers
        //return sum of n natural no. - sum of all available no. 
        int n=nums.length;
        int sum_of_all_n_numbers=n*(n+1)/2;
        int sum_of_no_array=0;

        for(int i=0;i<nums.length;i++)
        {
            sum_of_no_array+=nums[i];
        }
        return sum_of_all_n_numbers - sum_of_no_array;

    }
}