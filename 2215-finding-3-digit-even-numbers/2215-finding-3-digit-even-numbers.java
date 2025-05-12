class Solution {

    public boolean isValid(int[] digits, int d1, int d2, int d3) {
        
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        freq[d1]--;
        freq[d2]--;
        freq[d3]--;

        return freq[d1] >= 0 && freq[d2] >= 0 && freq[d3] >= 0;
    }

    public int[] findEvenNumbers(int[] digits) {
        List<Integer> list = new ArrayList<>();

        for (int num = 100; num <= 999; num += 2) { 
            int d3 = num % 10;
            int d2 = (num / 10) % 10;
            int d1 = num / 100;

            if (isValid(digits, d1, d2, d3)) {
                list.add(num);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}