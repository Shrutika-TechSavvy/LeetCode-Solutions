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
    boolean ans=true;
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int lh=getHeight(root.left);
        int rh=getHeight(root.right);

        if (Math.abs(lh - rh) > 1) {
            ans = false;
        }

        return Math.max(lh, rh) + 1;

    }
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return ans;
        
    }
}