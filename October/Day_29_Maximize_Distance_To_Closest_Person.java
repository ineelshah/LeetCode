class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int start = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int distanceThroughStart = 0;
        int i = 0;
        int distanceThroughEnd = 0;
        while(i < seats.length && seats[i] != 1) {
            i++;
        }
        distanceThroughStart = i - start;
        i = seats.length - 1;
        while(i > 0 && seats[i] != 1) {
            i--;
        }
        distanceThroughEnd = seats.length - i - 1;
        
        for(i = 0; i < seats.length; i++) {
            if(seats[i]== 1) {
                int distance = i - start;
                if(maxDistance < distance) {
                    maxStart = start;
                    maxEnd = i;
                    maxDistance = distance;
                }
                start = i;
            }
        }
        return Math.max(distanceThroughStart, Math.max(distanceThroughEnd, (maxEnd - maxStart) / 2));
    }
}