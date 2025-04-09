import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            if (num < k) return -1;  
        }

        // only need unique number
        Set<Integer> greater = new HashSet<>();
        for (int num : nums) {
            if (num > k) greater.add(num);
        }

        return greater.size();
    }
}