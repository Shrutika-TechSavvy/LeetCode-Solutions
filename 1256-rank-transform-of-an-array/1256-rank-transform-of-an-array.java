class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Step 1: Create a copy of the array and sort it
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Step 2: Use a HashMap to store the rank of each element
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // Step 3: Assign ranks to the elements in sorted order
        for (int i = 0; i < sortedArr.length; i++) {
            if (!rankMap.containsKey(sortedArr[i])) {
                rankMap.put(sortedArr[i], rank);
                rank++;
            }
        }

        // Step 4: Replace each element in the original array with its rank
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}