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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        int level=0;
        solve(root, ans, level);
        return ans;
    }
    public void solve(TreeNode node, List<Integer> ds, int level){
        if(node==null) return;

        if(ds.size() == level) ds.add(node.val);

        solve(node.right, ds, level+1);
        solve(node.left, ds, level+1);
    }
}