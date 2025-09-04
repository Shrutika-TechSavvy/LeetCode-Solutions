class Solution {
    public int findClosest(int x, int y, int z) {
        int diffXY= Math.abs(x - z);
        int diffZY = Math.abs(z - y);

        if(diffXY < diffZY) return 1;
        else if(diffXY > diffZY) return 2;

        return 0;
    }
}