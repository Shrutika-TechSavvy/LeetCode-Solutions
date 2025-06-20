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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
       //preorder(root,res);

       Stack<TreeNode> stack=new Stack<>();
       if(root == null) return res;
       stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            res.add(temp.val);
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
        }


       return res;

    }
    private void preorder(TreeNode root,List<Integer> res){
    if(root==null) return ;

        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
    
}