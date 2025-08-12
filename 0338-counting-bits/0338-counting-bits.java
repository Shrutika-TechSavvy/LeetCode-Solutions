
//this is teh optimal approach actually
//The observation is too impressive

class Solution {
    public int[] countBits(int n) {
        int result[] = new int[n  + 1 ];

        for(int i = 1; i <= n ; i++){
            if(i % 2 == 0) result[i]  = result[i / 2];
            else result[i] = result[i / 2] + 1;
        }
        return result;
        
    }
}

/*
Gives the brute force approach 

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
    // public int[] countBits(int n) {
    //     int arr[]=new int[n+1];
    //     int count=0;
    //     for(int i=0;i<=n;i++)
    //     {
    //         arr[i]=countSetBits(i);
    //     }
    //     return arr;
    // }

    public int[] countBits(int n ){
        int arr[] = new int[n+1];
        int count = 0;

        for(int i = 0 ; i <= n; i++){
            arr[i] = Integer.bitCount(i);
        }

        return arr;

    }
}

*/