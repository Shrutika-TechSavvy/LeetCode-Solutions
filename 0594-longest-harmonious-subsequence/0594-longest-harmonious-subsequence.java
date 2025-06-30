class Solution {
    public int findLHS(int[] nums) {
        //Brute force approach: 
        /* 
        1. Find out tye frequency of each of teh no. present in the nums array
        2. Go through the hashmap again,
             If the difference between two keys is exact 1, then add their frequencies and update longestHS
        3. Return longestHS
        */

        HashMap<Integer, Integer> hm =new HashMap<>();
        for(int i : nums ){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int longestHS = 0;
        for(int key : hm.keySet() ){
            if(hm.containsKey(key + 1 ) ){
                longestHS =Math.max(hm.get(key) + hm.get(key + 1), longestHS);
            }
        }

        return longestHS;

    }
}