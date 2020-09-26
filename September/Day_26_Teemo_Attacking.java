class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int lastPoisonedEndTime = 0;
        int currentPoisonedEndTime = 0;
        int totalPoisonedUnits = 0;
        
        for(int i = 0; i < timeSeries.length; i++) {
            currentPoisonedEndTime = timeSeries[i] + duration;
            totalPoisonedUnits += currentPoisonedEndTime - Math.max(lastPoisonedEndTime, timeSeries[i]);
            lastPoisonedEndTime = currentPoisonedEndTime;
        }
        return totalPoisonedUnits;        
    }
}