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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }

    int findMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        int leftMaxPath = Math.max(0, findMaxPathSum(root.left));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right));

        // Update maxSum if the path through root is better
        maxSum = Math.max(maxSum, leftMaxPath + rightMaxPath + root.val);

        // Return max path sum **starting from this node**
        return Math.max(leftMaxPath, rightMaxPath) + root.val;
    }
}
