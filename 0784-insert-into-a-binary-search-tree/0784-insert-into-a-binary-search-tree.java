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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if( root == null ) return new TreeNode(val);
        TreeNode curr=root;

        while(true){
            if( curr.val < val ){
                if( curr.right != null ){
                    curr = curr.right;
                }
                else{
                    //There's a null in the right of the curr node
                    curr.right = new TreeNode(val);
                    break;
                }
            }
            else{
                //The curr.val > val, go to left subtree
                if(curr.left != null ){
                    curr=curr.left;
                }
                else{
                    curr.left = new TreeNode(val);
                    break;
                }

            }
        }

        return root;
    }
}