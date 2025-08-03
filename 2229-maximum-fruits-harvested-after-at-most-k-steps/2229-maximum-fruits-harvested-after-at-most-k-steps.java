class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int left = 0, total = 0, maxFruits = 0;

        for (int right = 0; right < n; right++) {
            total += fruits[right][1];

            // Shrink window from left if cannot visit both ends within k steps
            while (left <= right && !canVisitBothEnds(fruits, startPos, k, left, right)) {
                total -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits;
    }

    private boolean canVisitBothEnds(int[][] fruits, int startPos, int k, int left, int right) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];

        // Two ways:
        // Go to left end first, then right: distance = (startPos - leftPos) + (rightPos - leftPos)
        // Go to right end first, then left: distance = (rightPos - startPos) + (rightPos - leftPos)
        int distLeftFirst = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        int distRightFirst = Math.abs(startPos - rightPos) + (rightPos - leftPos);

        return Math.min(distLeftFirst, distRightFirst) <= k;
    }
}