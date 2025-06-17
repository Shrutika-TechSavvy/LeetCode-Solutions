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
    
   /* public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       inorder(root,res);
       return res;

    }
    private void inorder(TreeNode root,List<Integer> res){
    if(root==null) return ;

        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
        
    }
    */
    //Morris traversal 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr=root;

        while(curr!=null){
            if( curr.left == null ){
                inorder.add(curr.val);
                curr=curr.right;
            }
            else{
                //The left is not null
                //Find the predecessor
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }

                //Case 2
                if(prev.right == null ){
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    //case 3
                    prev.right=null;
                    inorder.add(curr.val);
                    curr=curr.right;
                }
            }
        }

        return inorder;
    }
}