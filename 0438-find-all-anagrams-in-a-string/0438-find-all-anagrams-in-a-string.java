class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();

        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        String sortedP = new String(pArray);

        for(int i = 0 ; i <= sLen - pLen; i++){
            String sub = s.substring(i, i+pLen);
            char[] subarray = sub.toCharArray();
            Arrays.sort(subarray);
            String sortedSub = new String(subarray) ;

            if(sortedSub.equals(sortedP)) result.add(i);
        }

        return result;
    }
}