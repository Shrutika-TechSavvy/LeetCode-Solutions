class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Needed to find the top k frequent numbers, need optimized solution only
        //Frequency is HashMap
        //Top k is heap

        //Base cases
        if(nums.length == 1 && k == 1)  return new int[]{nums[0]};

        HashMap<Integer, Integer> map = new HashMap<>();

        //Caluclating the frequency of elements
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] ,  map.getOrDefault(nums[i] , 0) + 1);
        }
        int ans[] =map.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
                    .limit(k)
                    .mapToInt(Map.Entry :: getKey)
                    .toArray();
        //Needs to sort the hashmap based on the value in ascending order
        return ans;
    }
}