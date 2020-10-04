class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int count = 0;
        int max = 0;
        for(int i = 0; i < intervals.length; i++) {
            if(i != intervals.length - 1 && intervals[i][0] == intervals[i + 1][0]) {
                count++;
            }
            else if(intervals[i][1] <= max) {
                count++;
            }
            max = Math.max(intervals[i][1], max);
            
        }
        return intervals.length - count;
    }
}