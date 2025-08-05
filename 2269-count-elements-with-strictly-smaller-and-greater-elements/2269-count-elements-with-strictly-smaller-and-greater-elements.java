class Solution {
    public int countElements(int[] nums) {
        int n = nums.length;
        
        int count = 0;
        
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        for(int i = 0 ; i < n ; i++){
            if(nums[i] > min && nums[i] < max) count++;
        }
        return count;
    }
}