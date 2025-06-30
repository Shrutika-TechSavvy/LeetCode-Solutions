class Solution {
    public int findLHS(int[] nums) {
        //Brute force approach: 
        /* 
        1. Find out tye frequency of each of teh no. present in the nums array
        2. Go through the hashmap again,
             If the difference between two keys is exact 1, then add their frequencies and update longestHS
        3. Return longestHS
        
        //TC: O(N) + O(N)
        //SC:O(N)
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

        */
        //Optimal approach
        Arrays.sort(nums);
        int left = 0; 
        int right = 1;
        int n = nums.length;
        int res = 0;

        while( right < nums.length){
            int diff = nums[right] - nums[left];
            if(diff == 1 ){
                res = Math.max(res, right-left+1);
            }
            if(diff <= 1) right++;
            else left++ ;
        }
        return res;
    }
}