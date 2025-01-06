class Solution {
    public int findPeakElement(int[] arr) {
        
        int n=arr.length;
        if(n==1) return 0;   //becaus eit is stated that nums[-1] = nums[n] = -∞
        if(arr[0] > arr[1]) return 0;  //if 1st element iis the peak
        if(arr[n-1] > arr[n-2]) return n-1;  //if the last elemnt is the peak

        //Now, not found the peak element at 1s and n-1 position
        //do binary search on remaining for finding the peak element
        int low=1;
        int high= n-1;  //becaus emanuall y handled the condition for last and 1st position, element

        int mid=0;
        while(low<=high){

            mid=low+(high-low)/2;

            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(arr[mid -1] < arr[mid]){  //lied on increasing curve

                //This means we are in the left half and we should eliminate it as our peak element appears on the right
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return -1;
    }
}