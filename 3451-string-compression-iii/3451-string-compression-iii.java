class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i=0;
        while(i<word.length()){
            int count = 0;
            char temp = word.charAt(i);
            while(i<word.length() && word.charAt(i)==temp && count<9){
                count++;
                i++;
            }
            comp.append(count).append(temp);
        }
        return comp.toString();
    }
}