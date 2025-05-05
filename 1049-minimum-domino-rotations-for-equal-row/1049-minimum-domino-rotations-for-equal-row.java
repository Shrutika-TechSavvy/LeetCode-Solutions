class Solution {
    public int minDominoRotations(int[] tops, int[] bots) {
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;

        int num1 = tops[0];
        int num2 = bots[0];

        for (int i = 0; i < tops.length; i++) {
            // count1: Make top all num1
            if (count1 != Integer.MAX_VALUE) {
                if (tops[i] == num1) {
                    // do nothing
                } else if (bots[i] == num1) {
                    count1++;
                } else {
                    count1 = Integer.MAX_VALUE;
                }
            }

            // count2: Make bottom all num1
            if (count2 != Integer.MAX_VALUE) {
                if (bots[i] == num1) {
                    // do nothing
                } else if (tops[i] == num1) {
                    count2++;
                } else {
                    count2 = Integer.MAX_VALUE;
                }
            }

            // count3: Make bottom all num2
            if (count3 != Integer.MAX_VALUE) {
                if (bots[i] == num2) {
                    // do nothing
                } else if (tops[i] == num2) {
                    count3++;
                } else {
                    count3 = Integer.MAX_VALUE;
                }
            }

            // count4: Make top all num2
            if (count4 != Integer.MAX_VALUE) {
                if (tops[i] == num2) {
                    // do nothing
                } else if (bots[i] == num2) {
                    count4++;
                } else {
                    count4 = Integer.MAX_VALUE;
                }
            }
        }

        int result = Math.min(Math.min(count1, count2), Math.min(count3, count4));
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
