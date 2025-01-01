class Solution {
    public int maxScore(String s) {
        int max=0;

        for(int i=0;i<s.length()-1;i++)
        {
            int zeroCount=0;
            int onesCount=0;

            for(int k=0;k<i+1;k++)
            {
                if(s.charAt(k)=='0')
                {
                    zeroCount++;
                }
            }

            for(int j=i+1; j<s.length();j++)
            {
                if(s.charAt(j)=='1')
                {
                    onesCount++;
                }
            }

            if(max< (zeroCount+onesCount))
            {
                max=zeroCount+onesCount;
            }
        }

        return max;
    }
}