class Solution
{
    public int[][] mergeArrays(int[][] nums1, int[][] nums2)
    {
        Map<Integer,Integer> map = new TreeMap<>();
        Arrays.stream(nums1).forEach(num->map.put(num[0],num[1]));
        Arrays.stream(nums2).forEach(num->map.put(num[0],num[1]+map.getOrDefault(num[0],0)));
        return map.entrySet().stream().map(num->new int[]{num.getKey(),num.getValue()}).toArray(int[][]::new);
    }
}