class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int start = meetings[0][0];
        int end = meetings[0][1];

        int count = start == 1 ? 0: start-1;
        for(int i=1;i<meetings.length;i++){
            if(end<meetings[i][0]){
                count += meetings[i][0]-end-1;
                System.out.println(count);
            }
            end = Math.max(end,meetings[i][1]);
        }
        count += end==days ? 0:days-end;
        return count;
    }
}