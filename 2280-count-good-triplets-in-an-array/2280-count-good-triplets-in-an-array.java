class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int[] tree=new int[n+1],posOfV2InArr2=new int[n],posOfArr2InArr1=new int[n];
        for(int i=0;i<n;i++) posOfV2InArr2[nums2[i]]=i;
        for(int i=0;i<n;i++) posOfArr2InArr1[posOfV2InArr2[nums1[i]]]=i;
        long res = 0;
        for(int i2=0;i2<n;i2++) {
            int pos=posOfArr2InArr1[i2];
            //finds how many values to the left of arr2[i2] are on the left of pos_in_arr1_of(arr2[i2])
            int left=query(pos,tree);
            // the number of elegible possitions to the right of pos_in_arr1_of(arr2[i2]) are the
            //(total_remaining_on_the_left)-(in_the_left_of_arr2_but_not_in_the_left_of_arr1)
            int right=(n-1-pos)-(i2-left);
            res+=(long)left*right;
            //for next iteration inform to the right of pos_in_arr1_of(arr2[i2]) that ther is one
            //more elegible to the left
            update(pos,1,tree);
        }
        return res;
    }

    public void update(int index, int delta, int[] tree) {
        for(int p=index+1;p<tree.length;p+=p&-p) tree[p]+=delta;
    }

    public int query(int index,int[] tree) {
        int res = 0;
        for(int p=index+1;p>0;p-=p&-p) res+=tree[p];
        return res;
    }
}