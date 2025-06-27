class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //Algprithm: 
        //1. Reverse the edges ie. reverse the graph
        //2. apply the topo sort 
        //3. return the array of safe nodes

        List<List<Integer>> adjRev=new ArrayList<>();
        for( int i=0; i<graph.length ;i++) adjRev.add(new ArrayList<>());

        int indegree[] =new int[graph.length];

        //Reverse the graph
        for(int i = 0 ; i < graph.length; i++){
            for(int v: graph[i]) {
                // reverse edge v -> u
                adjRev.get(v).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<graph.length; i++){
            if(indegree[i] == 0 ) q.add(i);
        }
        List<Integer> safeNodes=new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            safeNodes.add(node);
            for( int it: adjRev.get(node) ){
                indegree[it]--;
                if(indegree[it] == 0 ) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
        
    }
}