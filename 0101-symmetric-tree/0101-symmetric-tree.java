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
    public boolean solve(TreeNode head1, TreeNode head2){
        if(head1 == null && head2 == null ) return true;
        if(head1 == null || head2 == null  || head1.val!=head2.val )return false;
        //if(head1.val == head2.val ) return true;

        return solve(head1.left, head2.right) && solve(head1.right, head2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if( root == null ) return false;
        return solve(root.left, root.right);
        
    }
}