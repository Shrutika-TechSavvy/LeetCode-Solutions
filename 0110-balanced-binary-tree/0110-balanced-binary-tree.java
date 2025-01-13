
class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightOf(root) != -1; // if this return means unbalanced (false)
    }

    private int heightOf(TreeNode root){
        if(root == null) return 0;

        int leftH = heightOf(root.left);
        if(leftH == -1) return -1;
        int rightH = heightOf(root.right);
        if(rightH == -1) return -1;

        if(Math.abs(leftH - rightH) > 1) return -1;
        
        return 1 + Math.max(leftH,rightH);
         }
}