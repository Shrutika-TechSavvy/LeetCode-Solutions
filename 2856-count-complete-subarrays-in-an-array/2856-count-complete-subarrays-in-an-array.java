class Solution {
    public int countCompleteSubarrays(int[] nums) {
        

        //Counting the no. of disctinct numbers in given array
        Set<Integer> set=new HashSet<>();
        for(int i: nums){
            set.add(i);
        }

        int totalDistinctElements=set.size();
        int totalCompleteSubarrays=0;
        set.clear();

        //sliding window to find the possible subarrays
        for(int i=0; i<nums.length; i++){
            set.clear();
            for(int j=i; j<nums.length; j++){
                set.add(nums[j]);
                if(set.size() == totalDistinctElements ){
                    totalCompleteSubarrays++;
                }
            }
        }

        return totalCompleteSubarrays;
    }
}