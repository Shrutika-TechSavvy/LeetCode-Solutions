class Solution {
    public int longestConsecutive(int[] nums) {
        //My approach is to use the Treeset as per requirement
        if(nums.length == 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        int count = 0, max = 1;
        int j = 0;
        List<Integer> list = new ArrayList<>(set);

        for(int i = 0; i < list.size() - 1; i++){
            j = i+1;
            if(list.get(j) - list.get(i) == 1){
                count++;
               // j++;
            }
            else{
                max = Math.max(count + 1, max);
                count= 0;
            }
        }
        max = Math.max(count + 1, max);
        return max;
        
    }
}