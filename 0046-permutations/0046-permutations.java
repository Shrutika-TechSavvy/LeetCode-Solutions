class Solution {

    public void solve(int[] nums, List<List<Integer>> ans, List<Integer> current) {
        // Base case: If current permutation is complete
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Recursive case: Try adding each element in nums
        for (int i = 0; i < nums.length; i++) {
            // Skip if nums[i] is already in current permutation
            if (current.contains(nums[i])) {
                continue;
            }
            current.add(nums[i]);
            solve(nums, ans, current);

            // Backtrack: Remove the last added element to explore other possibilities
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        // Starting recursion
        solve(nums, answer, current);

        return answer;
    }
}
