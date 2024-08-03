class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        
        // Check if the sorted arrays are equal
        return Arrays.equals(target, arr);
    }
}