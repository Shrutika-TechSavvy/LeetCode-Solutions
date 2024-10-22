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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        // List to store the sums of each level
        List<Long> levelSums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level-order traversal (BFS)
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;

            // Iterate over all nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                // Add left and right children to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add the level sum to the list
            levelSums.add(levelSum);
        }

        // Sort level sums in descending order
        Collections.sort(levelSums, Collections.reverseOrder());

        // If there are fewer than k levels, return -1
        if (k > levelSums.size()) {
            return -1;
        }

        // Return the k-th largest level sum
        return levelSums.get(k - 1);
    }
}