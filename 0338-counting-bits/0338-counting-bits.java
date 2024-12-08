class Solution {

    static int countSetBits(int n)
    {
        int count=0;
        while(n>0)
        {
            count+=n&1;
            n=n>>1;
        }
        return count;
    }
    public int[] countBits(int n) {
        int arr[]=new int[n+1];
        int count=0;
        for(int i=0;i<=n;i++)
        {
            arr[i]=countSetBits(i);
        }
        return arr;
    }
}