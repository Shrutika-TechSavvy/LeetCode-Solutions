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
    public TreeNode buildTrees ( int[] preorder, int preStart, int preEnd,
                                int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap ){

            if(preStart > preEnd || inStart > inEnd ) return null;
            TreeNode root=new TreeNode (preorder[preStart]);

            int inRoot=inMap.get(root.val);   //Now to get the index in inorder where the root is there like whuch we git from the preorder 
            int numsLeft=inRoot-inStart;   //to find the no. of elements of left subtree . Like all teh elemeents in the left of root in inorder are the left subtree

            root.left=buildTrees(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
            root.right=buildTrees(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

            return root;

                                }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap=new HashMap<>();
        //  Value  , Index

        //inorder madhlya tya particular valuse saaathi ky index ahe , uske liye mapping hai
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        TreeNode root=buildTrees(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
        return root;
        
    }
}