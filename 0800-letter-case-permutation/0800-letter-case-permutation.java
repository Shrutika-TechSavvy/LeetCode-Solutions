class Solution {

    public void generatePermutation(int index, StringBuilder temp, String s, List<String> answer){

        //Base Condition
        if(index>=s.length()){
            answer.add(temp.toString());
            return;
        }

        char ch=s.charAt(index);
        if(!Character.isDigit(ch)){
            if(Character.isUpperCase(ch)){
                temp.append(Character.toLowerCase(ch));
            }
            else if(Character.isLowerCase(ch)){
                temp.append(Character.toUpperCase(ch));
            }
            generatePermutation(index+1, temp, s, answer);
            temp.deleteCharAt(temp.length() - 1);
        }
        temp.append(ch);
        generatePermutation(index + 1, temp, s, answer);
        temp.deleteCharAt(temp.length() - 1);    
    

    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        generatePermutation(0,temp, s, ans); 
        return ans;
    }
}