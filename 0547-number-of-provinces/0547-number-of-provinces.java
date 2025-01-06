class Solution {
    
    public void dfs(int node, int[][] adj, boolean[] vis) {
        vis[node] = true;
        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1 && !vis[i]) {
                dfs(i, adj, vis);
            }
        }
    }
    
    public int findCircleNum(int[][] adj) {
        int V = adj.length;
        boolean[] vis = new boolean[V];
        int cnt = 0;
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, adj, vis);
            }
        }
        
        return cnt;
    }
}