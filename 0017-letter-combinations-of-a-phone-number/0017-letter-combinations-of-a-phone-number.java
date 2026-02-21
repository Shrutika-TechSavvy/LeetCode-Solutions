class Solution {

    public static void solve(String digits,  StringBuilder output, List<String> answer, int index, String mapping[])
    {
        if(index>=digits.length())
        {
            answer.add(output.toString());
            return;
        }

        int number=digits.charAt(index)-'0';
        String value=mapping[number];

        for(int i=0;i<value.length();i++)
            {
                output.append(value.charAt(i));
                solve(digits, output, answer, index+1,mapping);
                output.deleteCharAt(output.length() - 1);

        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> answer=new ArrayList<>();
        StringBuilder output=new StringBuilder();
        
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        String mapping[]={"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        solve(digits, output, answer, 0,mapping);
        return answer;
    }
}