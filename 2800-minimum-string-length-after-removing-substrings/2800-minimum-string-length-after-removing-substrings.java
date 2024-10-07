class Solution {
    public int minLength(String s) {
        boolean b = true;
        while(b){
            boolean x=false;
            for(int i=0; i<s.length()-1; i++){
                String temp =s.substring(i,i+2);
                if(temp.equals("AB") || temp.equals("CD")){
                    s = s.substring(0,i)+ s.substring(i+2,s.length());
                    x=true;
                }
            }
            b=x;
        }

        return s.length();
    }
}