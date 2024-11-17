class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
         int j = 0 ;
         Deque<Integer> dq = new LinkedList<>();
         long arr[] = new long [n];
         int res = Integer.MAX_VALUE;
         while(j<n){
            if(j == 0){
                arr[j] = nums[j];
            }else{
               arr[j] = arr[j-1]+nums[j];
            }
            if(arr[j]>= k){
                res = Math.min(res , j+1);
            }
            while(!dq.isEmpty() && arr[j]- arr[dq.peekFirst()] >= k){
                res = Math.min(res , j-dq.peekFirst());
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[j] <= arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(j);
            j++;
         }
         return  res== Integer.MAX_VALUE?-1:res;
    }
}