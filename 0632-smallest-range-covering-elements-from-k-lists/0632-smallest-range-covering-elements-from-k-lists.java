
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                points.add(new int[]{num, i});
            }
        }
        
        points.sort(Comparator.comparingInt(a -> a[0]));  
        
        int[] freqs = new int[nums.size()];
        int touched = 0;
        int start = 0;
        int resStart = points.get(0)[0], resEnd = points.get(points.size() - 1)[0];
        int interval = resEnd - resStart + 2;
        
        for (int i = 0; i < points.size(); i++) {
            int num = points.get(i)[0];
            int idx = points.get(i)[1];
            
            if (freqs[idx] == 0) {
                touched++;
            }
            freqs[idx]++;
            
            while (touched == nums.size()) {
                if (num - points.get(start)[0] < interval) {
                    resStart = points.get(start)[0];
                    resEnd = num;
                    interval = num - points.get(start)[0];
                }
                
                freqs[points.get(start)[1]]--;
                if (freqs[points.get(start)[1]] == 0) {
                    touched--;
                }
                start++;
            }
        }
        
        return new int[]{resStart, resEnd};
    }
}