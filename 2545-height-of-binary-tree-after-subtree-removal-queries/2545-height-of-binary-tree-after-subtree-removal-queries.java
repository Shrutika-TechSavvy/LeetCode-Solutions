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
    static final int[] htWithout = new int[100_001];
    int maxh = 0;
    boolean chk = true;
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        maxh = 0;
        helper(root, 0);
        if (!chk) {
            maxh = 0;
            helper1(root, 0);
        }
        
        int[] res = new int[queries.length];
        for (int i = queries.length - 1; i >= 0; i--)
            res[i] = htWithout[queries[i]];
        return res;
    }
    
    
    private void helper(TreeNode node, int h) {
        htWithout[node.val] = maxh;
        if (h > maxh)  maxh = h;
        if (node.left == null) {
            if (node.right != null)  helper(node.right, h + 1);
        } else if (node.right != null) {
            helper(node.left, h + 1);
            helper(node.right, h + 1);
            chk = false;
        } else {
            helper(node.left, h + 1);
        }
    }


    private void helper1(TreeNode node, int h) {
        if (maxh > htWithout[node.val])  htWithout[node.val] = maxh;
        if (h > maxh)  maxh = h;
        if (node.right != null)  helper1(node.right, h + 1);
        if (node.left != null)  helper1(node.left, h + 1);
    }
}