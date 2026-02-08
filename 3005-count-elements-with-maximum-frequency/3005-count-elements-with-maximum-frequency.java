class Solution {
    public int maxFrequencyElements(int[] nums) {
        //Initial step is to count the frequency of the arr eleements
        int answer = 0;
        HashMap<Integer, Integer> map  = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0 ) + 1);
        }
        for(int value : map.values()){
            if(value == Collections.max(map.values())) answer += value;
        }

        return answer;

    }
}