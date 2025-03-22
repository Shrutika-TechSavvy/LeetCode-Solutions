class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }

        int ans = 0;

        boolean[] visited = new boolean[n];
        for(int i =0; i<n; i++){
            if(!visited[i]){
                int[] doubleCntEdge = new int[]{0};
                int[] nodeCnt = new int[]{0};
                dfs(map, visited, nodeCnt, doubleCntEdge, i);
                int expectedNodesInCompleteComp = (nodeCnt[0] * (nodeCnt[0]-1)) / 2;
                if(doubleCntEdge[0]/2 == expectedNodesInCompleteComp){
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(HashMap<Integer, ArrayList<Integer>> map, boolean[] visited, int[] cntNode, int[] cntEdge, int node){
        if(!map.containsKey(node)) return;
        visited[node] = true;
        cntNode[0]++;
        for(int ngh: map.get(node)){
            cntEdge[0]++;
            if(!visited[ngh]){
                dfs(map, visited, cntNode, cntEdge, ngh);
            }
        }
    }
}