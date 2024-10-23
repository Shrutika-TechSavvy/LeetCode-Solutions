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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int prev=root.val;
        q.offer(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            int curr=0;
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                int levelsum=(node.left!=null ? node.left.val:0) + (node.right!=null ? node.right.val:0);
              if(node.left!=null)
              {
                node.left.val=levelsum;
                q.add(node.left);
              }
              if(node.right!=null)
              {
                node.right.val=levelsum;
                q.add(node.right);
              }
              curr+=levelsum;
              node.val=prev-node.val;
            }
            prev=curr;
        }
        return root;
    }
}