class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for(int i = 0; i < intervals.length; i++) {
            int[] pair = intervals[i];
            int currStart = pair[0];
            int currEnd = pair[1];
            if (currEnd <= prevEnd) {
                continue;
            }
            
            if(prevEnd >= currStart) {
                prevEnd = currEnd;
            }             
            else {
                list.add(new int[] {prevStart, prevEnd});
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }
        list.add(new int[] {prevStart, prevEnd});
        return list.toArray(new int[list.size()][]);
    }
}