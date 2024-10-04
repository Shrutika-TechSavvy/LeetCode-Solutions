class Solution {
    public long dividePlayers(int[] skills) {
        int totalSum = 0;
        int noOfGroups = skills.length / 2;

        // Calculate total sum of all skills
        for (int skill : skills)
            totalSum += skill;

        // If total sum cannot be evenly divided by the number of groups, return -1
        if (totalSum % noOfGroups != 0) return -1L;

        // Each group's skill sum should be equal to this value
        int groupSum = totalSum / noOfGroups;

        // Two pointers
        int left = 0;
        int right = skills.length - 1;
        long result = 0;

        // Sort the skills array
        Arrays.sort(skills);

        // Use two pointers to form valid groups
        while (left < right) {
            // Check if the sum of the current pair equals the required group sum
            if (skills[left] + skills[right] == groupSum) {
                result += (long) skills[left] * skills[right]; // Add product to result
            } else {
                return -1L; // Return -1 if the sum doesn't match
            }
            left++;
            right--;
        }

        return result; // Return the total result
    }
}