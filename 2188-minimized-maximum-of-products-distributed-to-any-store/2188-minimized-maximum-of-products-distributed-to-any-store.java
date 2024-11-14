class Solution {

    class Ratio {
        int ratio;
        int num_stores;
        int total_count;

        Ratio(int ratio, int num_stores, int tc) {
            this.ratio = ratio;
            this.num_stores = num_stores;
            this.total_count = tc;
        }
    }

    public int minimizedMaximum(int n, int[] q) {
        PriorityQueue<Ratio> pq = new PriorityQueue<>((a,b) -> b.ratio-a.ratio);
        for(int i = 0; i < q.length; i++) {
            pq.offer(new Ratio(q[i],1,q[i]));
        }
        int storeCount = q.length;
        while(storeCount < n){
            Ratio largest = pq.poll();
            pq.offer(new Ratio((int)Math.ceil((double)largest.total_count/(double)(largest.num_stores+1)), largest.num_stores + 1, largest.total_count));
            storeCount += 1;
        }

        return pq.poll().ratio;
    }
}
