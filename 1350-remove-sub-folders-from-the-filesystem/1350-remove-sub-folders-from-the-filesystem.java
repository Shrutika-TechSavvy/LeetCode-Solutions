class Solution {
    public List<String> removeSubfolders(String[] folder) {
        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> a.length() - b.length());

        Set<String> set = new HashSet();

        for(String s: folder){
            pq.offer(s);
        }

        while (!pq.isEmpty()) {
            boolean isPresent = false;
            String s = pq.poll();
            for(int i =1;i<s.length();i++){
                if(s.charAt(i) == '/'){
                    if(set.contains(s.substring(0,i))){
                        isPresent = true;
                        break;
                    }
                }
            }
            if (!isPresent) {
                set.add(s);
            }
        }
        return new ArrayList(set);
    }
}