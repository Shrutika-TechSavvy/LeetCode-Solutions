class Solution {
    public int minAddToMakeValid(String s) {
       int openCnt=0;

      int closeCnt = 0;
       
       for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                openCnt++;
            }else{
                if(openCnt > 0){
                    openCnt--;
                }else{
                    closeCnt++;
                }
            }
       }
       return openCnt + closeCnt ;
    }
}

