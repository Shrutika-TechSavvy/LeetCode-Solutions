import java.util.Arrays;

class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;

        HashMap<String, Integer> dp = new HashMap<>();

        return helper(values , dp);
    }

    public static int helper(int[] values , HashMap<String , Integer> dp)
    {
        if(values.length < 3) return 0;
        if (values.length == 3) { 
            return values[0] * values[1] * values[2];
        }

        String key = Arrays.toString(values);
        if(dp.containsKey(key)) return dp.get(key);

        int minScore = Integer.MAX_VALUE;
        
        for (int i = 1; i < values.length - 1; i++) {
            int score = values[0] * values[i] * values[values.length - 1];

            int leftScore = 0;
            int[] left = Arrays.copyOfRange(values, 0, i + 1);
            leftScore = helper(left , dp);
            
            int rightScore = 0;
            int[] right = Arrays.copyOfRange(values, i, values.length);
            rightScore = helper(right , dp);

            minScore = Math.min(minScore, score + leftScore + rightScore);
        }

        dp.put(key , minScore);
        return minScore;
    }
}