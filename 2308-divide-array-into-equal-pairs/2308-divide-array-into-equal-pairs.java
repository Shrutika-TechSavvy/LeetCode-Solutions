class Solution {
    public boolean divideArray(int[] nums) {
        
        //Brute force approach:
        //1. Point out the frequencey of all of the elements from array
        //After that check if any of the number has odd frequency , if yes return false it's not possible
        //else nums can be divided into the pairs

        //TC:O(N), SC:O(N)
        HashMap<Integer, Integer> freq =new HashMap<>();

        for(int num:nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        for(int count: freq.values()){
            if(count%2!=0){
                return false;
            }
        }

        return true;
    }
}