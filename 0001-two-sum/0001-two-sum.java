class Solution {
    public int[] twoSum(int[] nums, int target) {
        //create a hashmap
        //diff var between target and nums values
        //loop through nums array
        //check if map contains difference, if so return your current values index in a new array
        //and index of difference

        HashMap<Integer,Integer> map = new HashMap<>();
        

        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (!map.containsKey(diff)){
                map.put(nums[i], i);
            }
            else {
                return new int[]{map.get(diff), i};
            }
        }
        return new int[]{};


    }
}
