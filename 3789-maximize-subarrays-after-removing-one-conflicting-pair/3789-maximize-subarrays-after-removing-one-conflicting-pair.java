class Solution 
{
    public long maxSubarrays(int n, int[][] conflictingPairs) 
    {
        List<Integer>[] conflicts = new List[n + 2];
        for (int i = 0; i < conflicts.length; i++) 
        {
            conflicts[i] = new ArrayList<>();
        }        
        for (int[] pair : conflictingPairs) 
        {
            int a = pair[0];
            int b = pair[1];            
            if (a < b) 
            {
                conflicts[b].add(a);
            } 
            else 
            {
                conflicts[a].add(b);
            }
        }
        int maxLeft = 0;
        int secondMaxLeft = 0;
        long[] gains = new long[n + 2];
        long validSubarrays = 0;
        for (int right = 1; right <= n; right++) 
        {
            for (int left : conflicts[right]) 
            {
                if (left > maxLeft) 
                {
                    secondMaxLeft = maxLeft;
                    maxLeft = left;
                } 
                else if (left > secondMaxLeft) 
                {
                    secondMaxLeft = left;
                }
            }
            validSubarrays += right - maxLeft;
            gains[maxLeft] += maxLeft - secondMaxLeft;
        }
        long maxGain = 0;
        for (long gain : gains) 
        {
            if (gain > maxGain) 
            {
                maxGain = gain;
            }
        }
        return validSubarrays + maxGain;
    }
}