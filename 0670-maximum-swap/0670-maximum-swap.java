class Solution {
    public int maximumSwap(int num) {
        char arr[] = Integer.toString(num).toCharArray();
        int n = arr.length;
        char maxE = arr[n-1];
        int maxI = n-1;
        int swapI1 = -1;
        int swapI2 = -1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]>maxE){
                maxE = arr[i];
                maxI = i;
            }
            else if(arr[i]<maxE){
                swapI1 = i;
                swapI2 = maxI;
            }
        }
        if(swapI1!=-1){
            char temp = arr[swapI1];
            arr[swapI1] = arr[swapI2];
            arr[swapI2] = temp;
        }
        return Integer.parseInt(new String(arr));
    }
}