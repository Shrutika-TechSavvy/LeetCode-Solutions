class Solution {
    public int[] nse(int[] arr,int n){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] nge(int[] arr,int n){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

     public int[] pge(int[] arr,int n){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] pse(int[] arr,int n){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    public long sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] next=nse(arr,n);
        int[] prev=pse(arr,n);
        long total=0;
        for(int i=0;i<n;i++){
            int nx = next[i]-i;
            int pre=i - prev[i];
            total+= (pre * 1l * nx) * arr[i];
        }
        return total;
    }
    public long sumSubarrayMax(int[] arr) {
        int n=arr.length;
        int[] next=nge(arr,n);
        int[] prev=pge(arr,n);
        long total=0;
        for(int i=0;i<n;i++){
            int nx = next[i]-i;
            int pre=i - prev[i];
            total+= (pre *1l* nx) * arr[i];
        }
        return total;
    }
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums)-sumSubarrayMins(nums);
    }
}
/*
Brute force approach, TC:O(N^2), SC:O(1)
class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;

        for(int i = 0; i < nums.length; i++){
            int minimum = Integer.MAX_VALUE;
            int maximum = Integer.MIN_VALUE;

            for(int j = i; j < nums.length; j++){

                minimum = Math.min(minimum, nums[j]);
                maximum = Math.max(maximum, nums[j]);
                int range = maximum - minimum ; 
                sum += (long)range;
            }
        }

        return sum;
    }
}
 */