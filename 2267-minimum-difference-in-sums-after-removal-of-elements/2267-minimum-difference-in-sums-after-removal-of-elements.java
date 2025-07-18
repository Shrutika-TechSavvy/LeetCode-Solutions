class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length/3;
        long[] leftMin = new long[nums.length];
        long[] rightMax = new long[nums.length];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long leftSum = 0;
        long rightSum = 0;
        for(int i=0; i<2*n; i++) {
            leftSum += nums[i];
            maxHeap.offer(nums[i]);

            if(maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            leftMin[i] = leftSum;
        }

        for(int i=nums.length-1; i>=n; i--) {
            rightSum += nums[i];
            minHeap.offer(nums[i]);

            if(minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            rightMax[i] = rightSum;
        }

        long res = Long.MAX_VALUE;

        for(int i=n-1; i<=2*n-1; i++) {
            res = Math.min(res, leftMin[i] - rightMax[i+1]);
        }
        return res;
    }
}