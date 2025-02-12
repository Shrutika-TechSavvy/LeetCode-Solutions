class Solution {
    public int[] plusOne(int[] digits) {
        int i=digits.length-1;

        while(i>=0){
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i]=0;
            i--;

        }
        int[] newArr = new int[digits.length + 1];
        newArr[0]=1;
        for(int j=0;j<digits.length;j++){
            newArr[j+1]=digits[j];
        }

        return newArr;
    }
}