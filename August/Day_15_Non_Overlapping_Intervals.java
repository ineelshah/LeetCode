class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length == 0) 
            return 0;
        
		Arrays.sort(intervals,
                    (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
                   );
        
        int ans = 0;
        
        int nextStartPoint = Integer.MAX_VALUE;
        
        for(int i = intervals.length - 1; i >= 0; i--) {
            
            int currEndPoint = intervals[i][1];
            int currStartPoint = intervals[i][0];
            if(nextStartPoint < currEndPoint) 
                ans++;
            else 
                nextStartPoint = currStartPoint;
        }
        
        return ans;
    }
}