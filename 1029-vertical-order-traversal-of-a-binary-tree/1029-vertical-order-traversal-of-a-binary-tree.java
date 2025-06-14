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
    int leftMost = 0;
    int rightMost = 0;

    // Find leftmost and rightmost position
    void find(TreeNode root, int pos) {
        if (root == null) return;

        leftMost = Math.min(leftMost, pos);
        rightMost = Math.max(rightMost, pos);

        find(root.left, pos - 1);
        find(root.right, pos + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Step 1: Find bounds
        find(root, 0);
        int offset = -leftMost;
        int width = rightMost - leftMost + 1;
        int height = 1000; // assuming max depth won't exceed 1000

        // Step 2: Create 2D arrays
        List<Integer>[][] grid = new ArrayList[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }

        // Step 3: BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        queue.offer(root);
        index.offer(offset); // shifted position
        level.offer(0);

        int maxDepth = 0;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int pos = index.poll();
            int lvl = level.poll();

            maxDepth = Math.max(maxDepth, lvl);

            grid[pos][lvl].add(curr.val);

            if (curr.left != null) {
                queue.offer(curr.left);
                index.offer(pos - 1);
                level.offer(lvl + 1);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                index.offer(pos + 1);
                level.offer(lvl + 1);
            }
        }

        // Step 4: Extract final answer
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j <= maxDepth; j++) {
                if (!grid[i][j].isEmpty()) {
                    Collections.sort(grid[i][j]); // sorting as per problem requirement
                    col.addAll(grid[i][j]);
                }
            }
            if (!col.isEmpty())
                ans.add(col);
        }

        return ans;
    }
}
