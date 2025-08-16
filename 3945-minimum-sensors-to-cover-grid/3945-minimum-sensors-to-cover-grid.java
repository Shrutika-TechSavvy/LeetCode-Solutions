class Solution {
    public int minSensors(int n, int m, int k) {
        int cover = 2 * k + 1;  // side length covered by one sensor
        
        // how many sensors needed in rows
        int rows = (n + cover - 1) / cover; // ceil(n / cover)
        
        // how many sensors needed in columns
        int cols = (m + cover - 1) / cover; // ceil(m / cover)
        
        return rows * cols;
        
    }
}