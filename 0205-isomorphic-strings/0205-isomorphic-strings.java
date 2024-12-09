class Solution {
    public boolean isIsomorphic(String s, String t) {
        //Condition: If both the strings don't have the same langth, it's not isomorphic
        if(s.length()!=t.length())
        {
            return false;
        }

        //Data structure preferred for mapping each character with each other is HashMap
        HashMap<Character, Character> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        {
            char a=s.charAt(i);
            char b=t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b))
                continue;
                else
                return false;
            }
            else{
                if(!map.containsValue(b))
                    map.put(a,b);
                    else return false;
            }
        }
        return true;
    }
}