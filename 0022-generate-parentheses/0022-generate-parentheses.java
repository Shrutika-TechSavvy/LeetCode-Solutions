class Solution {

    //I have tried of doing this in more optimized way, check the green notebook
    public boolean isValid(StringBuilder curr) {
        int balance = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            // If balance goes negative, there are more ')' than '('
            if (balance < 0) {
                return false;
            }
        }
        // Should be zero if it's a valid parentheses string
        return balance == 0;
    }
    public void solve(List<String> res, StringBuilder curr, int n){

        if(curr.length()==2*n){
            if(isValid(curr)){
                res.add(curr.toString());
            }
            return;
        }

        curr.append("(");
        solve(res, curr, n);
       curr.deleteCharAt(curr.length() - 1);  // Backtrack

        curr.append(")");
        solve(res, curr, n);
        curr.deleteCharAt(curr.length() - 1);  // Backtrack

    }
    public List<String> generateParenthesis(int n) {
        
        List<String> res=new ArrayList<>();
        StringBuilder curr=new StringBuilder();
        solve(res, curr, n);
        return res;
    }
}