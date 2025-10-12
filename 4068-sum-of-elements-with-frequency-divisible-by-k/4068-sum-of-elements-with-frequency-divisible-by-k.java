class Solution {
    public int sumDivisibleByK(int[] nums, int k) {

        //Finding out the frequency 
        HashMap<Integer, Integer> hm  = new HashMap<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        //Elemet to store sume
        int total = 0;

        for(Map.Entry<Integer, Integer> mp : hm.entrySet()){
            int key = mp.getKey();
            int value = mp.getValue();

            if(value % k == 0){
                total += (key * value);
            }
        }

        return total;
    }
}