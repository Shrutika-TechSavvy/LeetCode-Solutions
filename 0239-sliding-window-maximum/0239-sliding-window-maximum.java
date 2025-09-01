class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //int j = k - 1, count=0;
        int N = nums.length;
        int[] res = new int[N - k + 1];

        /*int max = nums[0];
        for(int i = 0; i < N - k + 1; i++){
            while(i != j){
                max = Math.max(max, nums[j]);
                j--;
            }
            res[count++] = max;
            j = i + k -1;

        }

        return res;
        */
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        //Initialize the forst window
        for(int i =0; i<k; i++){
            pq.offer(new int[]{nums[i] ,  i});
        }

        res[0] = pq.peek()[0];
        //Slide the window
        for(int i = k; i<N; i++){
            pq.offer(new int[]{nums[i] , i});

            //Remove elements outside the current window
            while(pq.peek()[1] <= i-k) pq.poll();

            //Maximum for current window
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
}