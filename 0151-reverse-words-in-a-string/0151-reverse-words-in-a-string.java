class Solution {
    public String reverseWords(String s) {
        /*String[] str = s.trim().split("\\s+");
            String out = "";
            for (int i = str.length - 1; i > 0; i--) {
                // Append the current word and a space to the output
                out += str[i] + " ";
              }
        return out + str[0];

        */

        //Two pointers
        String part[] = s.trim().split("\\s+");
        int left = 0; int right =  part.length - 1;
        while(left<=right){
            String temp = part[left] ;
            part[left] = part[right];
            part[right] = temp;

            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<part.length; i++){
            sb.append(part[i]);
            if(i < part.length - 1){
                sb.append(" ");
            }

        }
        return sb.toString();
         
    }
}