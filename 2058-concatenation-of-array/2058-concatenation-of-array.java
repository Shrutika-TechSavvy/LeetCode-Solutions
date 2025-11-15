class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length * 2;
        int ans[] = new int[n];

        int c = 0;
        for(int i = 0; i < n; i++){
            if(c == nums.length){
                c=0;
            }
            ans[i] = nums[c];
            c++;
        }

        return ans;
    }
}