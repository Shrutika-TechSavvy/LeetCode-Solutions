class Solution {
    public int maxDepth(String s) {
        int count= 0;
        int n = s.length();

        if(n == 1) return 0;
        int max = 0;
        for(int i = 0 ; i< n; i++){
            if(s.charAt(i) == '('){
                count++;
                max = Math.max(max, count);
            }
            else if(s.charAt(i) == ')') count--;
        }

        return max;
    }
}