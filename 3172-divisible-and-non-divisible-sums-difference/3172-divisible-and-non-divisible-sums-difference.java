class Solution {
    public int differenceOfSums(int n, int m) {
        int sum=0;
        int sum2=0;
        for(int i=1;i<=n;i++){
            if(i%m==0)sum+=i;
            else{
                sum2+=i;
            }
        }
       // System.out.print(sum+" "+sum2);
        return sum2-sum;
    }
}