class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
       StringBuilder sb = new StringBuilder();
        char prev = ' ';
        boolean doubleA = false, doubleB = false, doubleC = false;
        while(c > 0 || b > 0 || a > 0){
            if(prev != 'c' && c >= b && c >= a && c >=2){
                sb.append("cc"); 
                prev = 'c';
                doubleC = true;
                c-=2;
            }
            else if(prev != 'a' && a >= c && a >= b && a >= 2){
                sb.append("aa"); 
                prev = 'a';
                doubleA = true;;
                a-=2;
            }
            else if(prev != 'b' && b >= c && b >= c && b >= 2){
                sb.append("bb"); 
                prev = 'b';
                doubleB = true;
                b-=2;
            }
            else{
                if(prev != 'a' && a > 0){
                    sb.append('a');
                    prev = 'a';
                    doubleA = false;
                    a--;
                }
                else if(prev != 'b' && b > 0){
                    sb.append('b');
                    prev = 'b';
                    doubleB = false;
                    b--;
                }
                else if(prev != 'c' && c > 0){
                    sb.append('c');
                    prev = 'c';
                    doubleB = false;
                    c--;
                }
                else if(prev == 'a' && !doubleA && a > 0){
                    sb.append('a');
                    prev = 'a';
                    doubleA = true;
                    a--;
                }
                else if(prev == 'b' && !doubleB && b > 0){
                    sb.append('b');
                    prev = 'b';
                    doubleB = true;
                    b--;
                }
                else if(prev == 'c' && !doubleC && c > 0){
                    sb.append('c');
                    prev = 'c';
                    doubleC = true;
                    a--;
                }
                else
                    break;
            }
        }
        return sb.toString();
    }
}