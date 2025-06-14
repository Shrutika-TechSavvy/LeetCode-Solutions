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
    int min = 0;
    int max = 0;

    // First traversal to determine leftmost and rightmost positions
    void find(TreeNode root, int pos) {
        if (root == null) return;

        min = Math.min(min, pos);
        max = Math.max(max, pos);

        find(root.left, pos - 1);
        find(root.right, pos + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Step 1: Get the min and max horizontal distance
        find(root, 0);
        int offset = -min;
        int cols = max - min + 1;
        int rows = 1000; // Assume max height won’t exceed 1000
        // To simplify, we can fix a large number of rows (can be optimized with another pass)

        // Step 2: Arrays for storing nodes at each vertical (column) and level (row)
        List<Integer>[][] grid = new ArrayList[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }

        // Step 3: BFS traversal
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> posQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        nodeQueue.offer(root);
        posQueue.offer(offset); // Shift position so index is non-negative
        levelQueue.offer(0);

        int maxLevel = 0;

        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            int pos = posQueue.poll();
            int level = levelQueue.poll();
            maxLevel = Math.max(maxLevel, level);

            grid[pos][level].add(current.val);

            if (current.left != null) {
                nodeQueue.offer(current.left);
                posQueue.offer(pos - 1);
                levelQueue.offer(level + 1);
            }

            if (current.right != null) {
                nodeQueue.offer(current.right);
                posQueue.offer(pos + 1);
                levelQueue.offer(level + 1);
            }
        }

        // Step 4: Prepare final answer
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j <= maxLevel; j++) {
                if (!grid[i][j].isEmpty()) {
                    Collections.sort(grid[i][j]); // Sort for vertical traversal rule
                    col.addAll(grid[i][j]);
                }
            }
            ans.add(col);
        }

        return ans;
    }
}
