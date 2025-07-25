class Solution {
    public int findLucky(int[] arr) {
        //find the frequency
        int ans=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0 ) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) == key ){
                ans = key;
            }
        }
        return ans;
    }
}