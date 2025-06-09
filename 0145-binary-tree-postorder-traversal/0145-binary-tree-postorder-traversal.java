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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        //Using teh single stack
        //It is similarly like the preorder iterative but just use the reverse sequence NRL, and tehn reverse it to get the postorder

        Stack<TreeNode> stack=new Stack<>();
        if(root == null) return res;

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            res.add(temp.val);

            if(temp.left!=null) stack.push(temp.left);
            if(temp.right!=null) stack.push(temp.right);
        }
        Collections.reverse(res);
       //postorder(root,res);//gois is part
       return res;

    }
    private void postorder(TreeNode root,List<Integer> res){
    if(root==null) return ;
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
}