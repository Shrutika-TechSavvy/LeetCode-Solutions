class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int SIZE = 26;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // Step 1: Initial frequency vector
        long[] freq = new long[SIZE];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Build transformation matrix
        long[][] mat = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            int span = nums.get(i);
            for (int j = 1; j <= span; j++) {
                int to = (i + j) % SIZE;
                mat[i][to] = (mat[i][to] + 1) % MOD;
            }
        }

        // Step 3: Matrix exponentiation
        long[][] matT = matrixPower(mat, t);

        // Step 4: Multiply matrix^t with frequency vector
        long[] result = new long[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i] = (result[i] + matT[j][i] * freq[j]) % MOD;
            }
        }

        // Step 5: Sum the final frequencies
        long total = 0;
        for (long val : result) {
            total = (total + val) % MOD;
        }

        return (int) total;
    }

    // Helper: Matrix exponentiation
    private long[][] matrixPower(long[][] base, int exp) {
        long[][] result = identityMatrix(SIZE);
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }
        return result;
    }

    // Helper: Matrix multiplication
    private long[][] multiply(long[][] A, long[][] B) {
        long[][] res = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < SIZE; j++) {
                    res[i][j] = (res[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return res;
    }

    // Helper: Identity matrix
    private long[][] identityMatrix(int n) {
        long[][] id = new long[n][n];
        for (int i = 0; i < n; i++) {
            id[i][i] = 1;
        }
        return id;
    }
}