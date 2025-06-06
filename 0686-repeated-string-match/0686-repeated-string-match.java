// time complexity -> O(n)
// space complexity -> O(n)

class Solution {
    public int repeatedStringMatch(String A, String B) {
        
        int count = 1;
        StringBuilder temp = new StringBuilder(A);

        while(temp.length() < B.length()) {
            temp.append(A);
            count++;
        }

        if(temp.toString().contains(B)) {
            return count;
        }

        if(temp.append(A).toString().contains(B)) {
            return count + 1;
        }

        return -1;
    }
}