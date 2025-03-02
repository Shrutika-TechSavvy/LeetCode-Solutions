class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<=nums.length-k; i++) {
            for(int j=i; j<i+k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }
        }

        int res = -1;

        for(Map.Entry<Integer, Integer> en : map.entrySet()) {
            if(en.getValue() == 1 || (nums.length == k)) {
                res = Math.max(res, en.getKey());
            }
        }

        return res;
        
    }
}