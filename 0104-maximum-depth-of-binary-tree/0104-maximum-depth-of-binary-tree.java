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

    public int solve(TreeNode root){
        if(root==null) return 0;

        return 1+Math.max(solve(root.left), solve(root.right));
    }
    public int maxDepth(TreeNode root) {
        
        //applying the bfs
        /*
        Queue<TreeNode> queue=new LinkedList<>();

        if(root!=null){
            queue.add(root);
        }
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0 ;i <size; i++){
                TreeNode currentNode=queue.poll();
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            level++;
        }

        return level;
        */

        return solve(root);
        
    }
}