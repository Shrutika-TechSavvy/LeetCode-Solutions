/*class Solution {

    class Pair {

        int first;
        int second;
        int third;

        Pair(int _first, int _second) {

            first = _first;
            second = _second;
        }
    }

    class Tuple {
        int first, second, third;

        Tuple(int f, int s, int t) {

            first = f;
            second = s;
            third = t;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {

        // creating the adjacency list of all the edges i. graph cinstruction
        List<List<Pair>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {

            // Given: flights[i] = [fromi, toi, pricei]
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            list.get(u).add(new Pair(v, wt));
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            int stops = t.first;
            int node = t.second;
            int cost = t.third;

            if (stops > k)
                continue;

            for (Pair itr : list.get(node)) {
                int adjNode = itr.first;
                int wt = itr.second;

                if (cost + wt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + wt;
                    queue.offer(new Tuple(stops+1, adjNode, dist[adjNode]));
                }
            }
        }

        if (dist[dest] ==  Integer.MAX_VALUE)
            return -1;
        return dist[dest];
    }
}*/

import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Perform Bellman-Ford relaxation for k+1 times
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, n); // Use a temp array to avoid overwriting in the same iteration
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];
                
                // Relax the edge if the source has been reached
                if (dist[u] != Integer.MAX_VALUE && dist[u] + cost < temp[v]) {
                    temp[v] = dist[u] + cost;
                }
            }
            dist = temp; // Update the distance array after each iteration
        }
        
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}
