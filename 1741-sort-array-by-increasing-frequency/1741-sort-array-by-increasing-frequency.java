class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        List<Integer> list = new ArrayList<>();
        for (int num : nums){
            freq[num + 100]++;
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            return freq[a + 100] == freq[b + 100] ? b - a : freq[a + 100] - freq[b + 100];
        });
        for (int i = 0; i < nums.length; i++)
            nums[i] = list.get(i);
        return nums;
    }
}