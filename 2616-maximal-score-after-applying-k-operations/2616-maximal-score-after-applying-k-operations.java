class Solution {
    public long maxKelements(int[] nums, int k) {
      long ans=0;
    PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
      for(int i:nums)pq.add(i);
      while(k-->0){
        ans+=pq.peek();
        int removed=pq.poll();
        pq.add((int)Math.ceil(removed/3.0));
      }
    return ans;
    }
}