class Solution {
    public int maximumSum(int[] nums) {
        //preparing the sum of digits ka array
       Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            
            // If we have already encountered this digit sum
            if (map.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, num + map.get(digitSum));
                map.put(digitSum, Math.max(map.get(digitSum), num)); // Store the larger number
            } else {
                map.put(digitSum, num);
            }
        }
        
        return maxSum;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}