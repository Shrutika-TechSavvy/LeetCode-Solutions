class Solution {
    private int getMinSwap(int[] tops, int[] bots, int target) {
        int swapT = 0, swapB = 0;
        for (int i = 0; i < tops.length; ++i) {
            if (tops[i] != target && bots[i] != target) return -1;
            if (tops[i] != target) ++swapT;
            else if (bots[i] != target) ++swapB;
        }
        return Math.min(swapT, swapB);
    }
    public int minDominoRotations(int[] tops, int[] bots) {
        int minSwapA = getMinSwap(tops, bots, tops[0]);
        int minSwapB = (tops[0] == bots[0]) ? -1 : getMinSwap(tops, bots, bots[0]);

        if (minSwapA == -1 && minSwapB == -1) return -1;
        if (minSwapB == -1) return minSwapA;
        if (minSwapA == -1) return minSwapB;
        return Math.min(minSwapA, minSwapB);
    }
}