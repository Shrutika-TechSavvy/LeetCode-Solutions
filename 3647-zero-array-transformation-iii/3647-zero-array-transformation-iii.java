class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
    int n = nums.length;
        int m = queries.length;

        // Sort queries by their start index
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        // Max-heap for available queries (by end index)
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap for active queries (by end index)
        PriorityQueue<Integer> active = new PriorityQueue<>();

        int qi = 0; // Pointer for queries

        for (int i = 0; i < n; i++) {
            // Add all queries starting at or before index i
            while (qi < m && queries[qi][0] <= i) {
                available.offer(queries[qi][1]);
                qi++;
            }

            // Remove active queries that no longer cover index i
            while (!active.isEmpty() && active.peek() < i) {
                active.poll();
            }

            // Activate queries as needed to cover nums[i]
            while (nums[i] > active.size()) {
                // Remove available queries that don't cover index i
                while (!available.isEmpty() && available.peek() < i) {
                    available.poll();
                }

                if (available.isEmpty()) {
                    return -1; // Not enough queries to reduce nums[i] to zero
                }

                // Activate the query with the largest end index
                active.offer(available.poll());
            }
        }

        // Remaining queries in 'available' can be removed
        return available.size();
    }
}