class Solution {
    public String[] divideString(String s, int k, char fill) {
        // Get the length of the input string
        int n = s.length();
        
        // Calculate the number of groups needed
        // (n + k - 1) / k is used to round up the division
        int groupCount = (n + k - 1) / k;

        // Initialize the result array to hold the groups
        String[] result = new String[groupCount];
        
        // Loop through each group
        for (int i = 0; i < groupCount; i++) {
            // Calculate the starting index for the current group
            int start = i * k;
            // Create a StringBuilder to build the current group string
            StringBuilder group = new StringBuilder();
            
            // Loop to fill the current group with characters
            for (int j = 0; j < k; j++) {
                // Check if the current index is within the bounds of the string
                if (start + j < n) {
                    // Append the character from the string to the group
                    group.append(s.charAt(start + j));
                } else {
                    // If out of bounds, append the fill character
                    group.append(fill);
                }
            }
            // Convert the StringBuilder to a string and store it in the result array
            result[i] = group.toString();
        }
        
        // Return the array of groups
        return result;
    }
}