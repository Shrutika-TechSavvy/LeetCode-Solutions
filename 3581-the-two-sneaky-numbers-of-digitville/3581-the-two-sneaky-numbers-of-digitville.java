class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        
        Set<Integer> seen = new HashSet<>();
        int[] result = new int[2];
        int index = 0;
        
        for(int num:nums)
        {
            if(seen.contains(num))
            {
                result[index++]=num;
                if(index==2)break;
            }
            else{
                seen.add(num);
            }
        }
        return result;
        
    }
}