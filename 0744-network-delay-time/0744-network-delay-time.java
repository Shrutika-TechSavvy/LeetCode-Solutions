class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int result[] = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[k-1] = 0;
   

    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

    for(int i = 0; i < n; i++){
        adj.add(new ArrayList<>());
    }
    //Preparing the list
    for(int i  = 0 ; i < times.length ; i++){
        int u = times[i][0] -1;
        int v = times[i][1] -1;
        int weight = times[i][2];

        adj.get(u).add(new int[]{v, weight});

    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[]{0, k-1});

    while(!pq.isEmpty()){
        int popped[] = pq.poll();
        int cost = popped[0];
        int node = popped[1];

        for(int [] neighbor : adj.get(node)){
            int neiNode = neighbor[0];
            int w = neighbor[1];

            if(result[neiNode] > w + cost){
                result[neiNode] = w + cost;
                pq.add(new int[]{result[neiNode], neiNode});
            }
        }
    }
    int max = Integer.MIN_VALUE;
    for(int i : result){
        if (i == Integer.MAX_VALUE) return -1;
        max = Math.max(max, i);
    }

    return max;

    }
}