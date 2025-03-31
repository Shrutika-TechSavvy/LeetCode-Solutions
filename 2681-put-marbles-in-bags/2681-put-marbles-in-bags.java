class Solution {
    public long putMarbles(int[] weights, int k) {
        // Edge cases
        if (k == 1 || k == weights.length) {
            return 0;
        }

        // Calculate split values
        for (int i = 0; i < weights.length - 1; i++) {
            weights[i] += weights[i + 1];
        }
        weights[weights.length - 1] = 0;

        // Sort the array (using radix sort)
        int[] sorted = radixSort(weights);

        // Calculate the difference between max and min sums
        long ans = 0;
        for (int i = 1; i < k; i++) {
            ans += sorted[sorted.length - i] - sorted[i];
        }
        return ans;
    }

    private int[] radixSort(int[] arr) {
        int[] output = new int[arr.length];
        countSort(arr, 0, output);
        countSort(output, 8, arr);
        countSort(arr, 16, output);
        countSort(output, 24, arr);
        return arr;
    }

    private void countSort(int[] arr, int offset, int[] output) {
        int[] count = new int[256];

        // Count occurrences
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] >>> offset) & 0xFF]++;
        }

        // Compute prefix sums
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // Build output array
        for (int i = arr.length - 1; i >= 0; i--) {
            int a = arr[i];
            output[--count[(a >>> offset) & 0xFF]] = a;
        }
    }
}