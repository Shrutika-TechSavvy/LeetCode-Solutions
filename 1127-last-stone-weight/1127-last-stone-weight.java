class Solution {
    public int lastStoneWeight(int[] stones) {

        //going to use the max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (y > x) {
                pq.add(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}