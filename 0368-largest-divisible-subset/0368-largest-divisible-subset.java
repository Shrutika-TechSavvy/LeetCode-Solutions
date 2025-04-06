class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> dp = new ArrayList<>();
    List<Integer> maxSubset = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        List<Integer> maxList = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            if (nums[i] % nums[j] == 0 && dp.get(j).size() > maxList.size()) {
                maxList = dp.get(j);
            }
        }
        List<Integer> newList = new ArrayList<>(maxList);
        newList.add(nums[i]);
        dp.add(newList);

        if (newList.size() > maxSubset.size()) {
            maxSubset = newList;
        }
    }

    return maxSubset;
}

}