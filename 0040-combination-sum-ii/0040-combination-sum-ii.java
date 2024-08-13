import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> result = null;

            public List<Integer> get(int i) {
                init();
                return result.get(i);
            }

            public int size() {
                init();
                return result.size();
            }

            private void init() {
                if (result != null) return;

                Arrays.sort(candidates);

                // Create a frequency map to count occurrences of each element
                Map<Integer, Integer> freqMap = new HashMap<>();
                for (int i : candidates) {
                    freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
                }

                // Convert frequency map to a list of arrays [element, frequency]
                List<int[]> freq = new ArrayList<>();
                freqMap.forEach((k, v) -> freq.add(new int[] { k, v }));

                Set<List<Integer>> set = new HashSet<>();
                impl(freq, 0, target, new ArrayList<>(), 0, set);
                result = new ArrayList<>(set);
            }
        };
    }

    private void impl(List<int[]> candidates, int start, int target, List<Integer> list, int sum, Set<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            int[] c = candidates.get(i);
            if (c[1] == 0) continue; // Skip if no occurrences left
            if (sum + c[0] > target) continue; // Skip if sum exceeds target

            // Choose the current element
            list.add(c[0]);
            c[1]--; // Decrease the count

            // Recurse with updated parameters
            impl(candidates, i, target, list, sum + c[0], result);

            // Backtrack: remove the current element and restore count
            list.remove(list.size() - 1);
            c[1]++;
        }
    }
}