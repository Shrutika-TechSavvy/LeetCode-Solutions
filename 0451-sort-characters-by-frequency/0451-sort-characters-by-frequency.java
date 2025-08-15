class Solution {
    public String frequencySort(String s) {
        //task is to sort teh array by frequency
        //?So, first needed to find out the frequency of all character
        
        HashMap<Character, Integer> map =new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        //Sorting the hashmap by the descending order
        var ls = new ArrayList<>(map.entrySet());
        ls.sort((a, b) -> b.getValue() - a.getValue());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ls.size(); i++){
            char ch = ls.get(i).getKey();
            int count = ls.get(i).getValue();
            while(count!=0){
                sb.append(ch);
                count --;
            }

        }
        return sb.toString();

    }
}