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
    private TreeNode lca(TreeNode root , TreeNode a , TreeNode b ){
        if(root==null) return null ;
        if( root == a ) return a ;
        if( root == b ) return b ;
        TreeNode l = lca( root.left , a , b ) ;
        TreeNode r = lca( root.right, a , b ) ;

        if( l == null ) return r ;
        if( r == null ) return l ;
        return root ; 
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<>() ;
        if(q.size()==1) return root ;
        q.add(root) ;
        List<TreeNode>list = new ArrayList<>() ;

        while(!q.isEmpty()){
           int n = q.size() ;
           list.clear() ;
           for( int i = 0 ; i < n ; i++ ){
            TreeNode temp = q.poll() ;
            list.add(temp) ;
            if(temp.left != null){
                q.add(temp.left) ;
            }
            if(temp.right != null){
                q.add(temp.right) ;
            }
           }
        }

        if(list.size()==1) return list.get(0) ;
        return lca( root , list.get(0) , list.get(list.size()-1) ) ;
        
    }
}