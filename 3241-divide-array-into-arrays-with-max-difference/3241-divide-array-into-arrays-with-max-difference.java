class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(nums[i+2]-nums[i]<=k){
                int[] arr=new int[3];
                arr[0]=nums[i];
                arr[1]=nums[i+1];
                arr[2]=nums[i+2];
                list.add(arr);
                i+=2;
            }
        }
        int n=nums.length;
        if(list.size()<n/3)
        return new int[0][0];
        return list.toArray(new int[0][]);
    }
}