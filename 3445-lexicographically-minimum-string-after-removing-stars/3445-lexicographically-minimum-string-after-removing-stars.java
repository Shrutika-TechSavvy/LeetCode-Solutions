class Solution {
    public String clearStars(String s) {
        TreeMap<Character, List<Integer>> mp = new TreeMap<>();
        Set<Integer> st = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '*') {
                Map.Entry<Character, List<Integer>> e = mp.firstEntry();
                List<Integer> li = e.getValue();
                st.add(li.get(li.size() - 1));
                li.remove(li.size() - 1);
                st.add(i);
                if(li.size() != 0) mp.put(e.getKey(), li);
                else mp.remove(e.getKey());
            } else {
                mp.putIfAbsent(ch, new ArrayList<>());
                mp.get(ch).add(i);
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!st.contains(i)) res.append(s.charAt(i));
        }
        return res.toString();

    }
}