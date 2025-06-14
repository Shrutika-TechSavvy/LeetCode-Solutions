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
/*
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


*/
//DFS
/*
class Solution{

    void dfs(TreeNode root, int hd, int[] min, HashMap<Integer, List<Integer>> mp){
        if( root == null ) return ;

        if(!mp.containsKey(hd)){
            mp.put(hd, new ArrayList<>() );
        }
        mp.get(hd).add(root.val);
        min[0] = Math.min ( min[0] , hd);

        //recursively traverse the left and right
        dfs( root.left, hd-1, min, mp);
        dfs( root.right, hd+1, min, mp);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer, List<Integer>> mp=new HashMap<>();
        int min[]={0};
        dfs(root, 0, min, mp);
        int hd=min[0];
        while(mp.containsKey(hd)){
            ans.add(mp.get(hd));
            hd++;
        }
        return ans;
    }

}
*/
class Solution {
    // Helper class to store row and value
    class Pair {
        int row, val;
        Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    // DFS to collect nodes with (hd, row, value)
    void dfs(TreeNode root, int hd, int row,
             int[] minHD,
             Map<Integer, List<Pair>> map) {
        if (root == null) return;

        map.putIfAbsent(hd, new ArrayList<>());
        map.get(hd).add(new Pair(row, root.val));
        minHD[0] = Math.min(minHD[0], hd);

        dfs(root.left, hd - 1, row + 1, minHD, map);
        dfs(root.right, hd + 1, row + 1, minHD, map);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        int[] minHD = {0};

        dfs(root, 0, 0, minHD, map);

        List<List<Integer>> result = new ArrayList<>();
        int hd = minHD[0];

        while (map.containsKey(hd)) {
            List<Pair> list = map.get(hd);
            list.sort((a, b) -> {
                if (a.row != b.row)
                    return Integer.compare(a.row, b.row);
                return Integer.compare(a.val, b.val);
            });

            List<Integer> col = new ArrayList<>();
            for (Pair p : list)
                col.add(p.val);

            result.add(col);
            hd++;
        }

        return result;
    }
}
