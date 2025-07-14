class Solution {
    Stack<Integer> stack = new Stack<>();

    int[] findPSE(int []arr){
        int n = arr.length;

        int pse[] = new int[arr.length];
        //We need to play with the index
        for(int i =0 ; i < n ; i++ ){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        return pse;
        
    }

    int[] findNSE(int arr[]){
        int n = arr.length;
        int nse[] = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        stack.clear();
        return nse;
    
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        //Previous Smaller element , index
        int pse[] = findPSE(arr);

        //Next smaller element;
        int nse[] = findNSE(arr);

        //Calculating the sum using formula 
        //sum = sum + arr[i] * ( i - pse[i]) * (nse[i] - i);
        long sum = 0;
        int mod = (int)1e9+7;
        for(int i = 0; i<n; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            sum = (sum + (long)arr[i] * left * right)%mod;
        }

        return (int)sum;
    }
}