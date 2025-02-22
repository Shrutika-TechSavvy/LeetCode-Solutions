/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int index=0;

    public TreeNode helper(String traversal, int depth){
        int dashCount = 0;
        int n = traversal.length();
        int start = index;

        // Counting the number of dashes
        while (start < n && traversal.charAt(start) == '-') {
            dashCount++;
            start++;
        }

        // If the depth does not match, return null (backtrack)
        if (dashCount != depth) {
            return null;
        }

        // Extract the numeric value of the node
        int numStart = start;
        while (start < n && Character.isDigit(traversal.charAt(start))) {
            start++;
        }

        int nodeValue = Integer.parseInt(traversal.substring(numStart, start));
        index = start; // Update global index

        // Create the current node
        TreeNode t = new TreeNode(nodeValue);

        // Recursively build left and right subtrees
        t.left = helper(traversal, depth + 1);
        t.right = helper(traversal, depth + 1);

        return t;

    }
    public TreeNode recoverFromPreorder(String traversal) {
        return helper(traversal, 0);
    }
}