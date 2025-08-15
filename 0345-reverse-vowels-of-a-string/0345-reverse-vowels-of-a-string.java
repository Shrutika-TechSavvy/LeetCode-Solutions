class Solution {
    public String reverseVowels(String s) {

        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');
        vowelSet.add('u');


        int left = 0, right = s.length() - 1;
        char[] arr = s.toCharArray();

        while(left <= right){
            while (left < right && !vowelSet.contains(arr[left])) left++;
            while (left < right && !vowelSet.contains(arr[right])) right--;

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
        
    }
}