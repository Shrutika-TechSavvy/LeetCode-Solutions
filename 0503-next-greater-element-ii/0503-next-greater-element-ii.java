class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //Optimized approach using Stack
        /*Steps: 
        1. Hypohetically , double the array then the size of array would be 2*N-1
        2. When actually u iterate through the array ie, i<N then start putting the next greater element in the result array
        3. Main logic is arr[i%N]
         */

        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];

        for(int i = 2*n-1; i>=0; i--){

            while(!st.isEmpty() && st.peek() <=  nums[i%n]) st.pop();

            if( i < n){
                if(!st.isEmpty()) result[i] = st.peek();
                else result[i] = -1;
            }
            
            st.push(nums[i%n]);
        }
        return result;
    }
}