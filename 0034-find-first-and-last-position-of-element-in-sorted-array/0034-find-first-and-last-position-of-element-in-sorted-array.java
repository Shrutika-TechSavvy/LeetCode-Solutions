class Solution {
    int firstOccurance(int nums[],int target)
    {
        int low = 0,high = nums.length-1,index = -1;

        while (low <= high) {
                int mid = low +  (high - low) /2;

                if(nums[mid] == target)
                {
                    index = mid;
                    high = mid -1;
                }
                else if(nums[mid] > target)
                {
                    high = mid -1;
                }
                else{
                    low = mid + 1;
                }
        }

        return index;
    }

    int lastOccurance(int nums[],int target)
    {
        int low=0,high = nums.length-1,index = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target)
            {
                index = mid;
                low = mid + 1;
            }
            else if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return index;
    }

    public int[] searchRange(int[] nums, int target) {

        int first = firstOccurance(nums, target);
        if(first == -1)
            return new int[]{-1,-1};
        else
            return new int[]{first,lastOccurance(nums, target)};
    }

}