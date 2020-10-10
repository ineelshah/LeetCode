class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;
        if(points.length == 1)
            return 1;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int pointEnd = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] > pointEnd) {
                arrows++;
                pointEnd = points[i][1];
            }
        }
        
        return arrows;
    }
}