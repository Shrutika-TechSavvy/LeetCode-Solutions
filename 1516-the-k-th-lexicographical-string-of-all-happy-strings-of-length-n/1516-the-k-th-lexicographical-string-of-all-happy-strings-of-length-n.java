class Solution {
    public String getHappyString(int n, int k) {
        // List<Character> happy= new ArrayList<>();
        StringBuilder happy= new StringBuilder();
        if(rec(n, k, 0, happy)){
            return happy.toString();
        }
        return "";
    }
    int count=0;
    public  boolean rec(int n, int k, int l, StringBuilder happy){
        if(l==n){
            count++;
            if(count==k) return true;
            return false;
        }
        for(char i='a';i<='c';i++){
            if(l==0 || happy.charAt(l-1)!=i){
                happy.append(i);
                if(rec(n, k, l+1, happy)) return true;
                happy.deleteCharAt(l);
            }
        }
        return false;
    }
}