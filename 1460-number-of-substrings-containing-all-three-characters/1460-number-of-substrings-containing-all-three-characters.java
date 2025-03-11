class Solution {
    public int numberOfSubstrings(String s) {
        //Brute force approach
        int freq[]=new int[3];  //The frequencey of a, b and c
        int n=s.length();
        int res=0;

        int i=0, j=0;
        while(j<n){
            char ch=s.charAt(j);
            freq[ch -'a']++;
            while(freq[0] >0 && freq[1]>0 && freq[2]>0){
                res+=(n-j);
                freq[s.charAt(i) -'a']--;
                i++;
            }
            j++;

        }

        return res;
    }
}