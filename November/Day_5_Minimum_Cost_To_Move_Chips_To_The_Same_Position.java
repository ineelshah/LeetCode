class Solution {
    public int minCostToMoveChips(int[] position) {
        int countOdds = 0;
        int countEvens = 0;
        for(int i = 0; i < position.length; i++) {
            if(position[i] % 2 != 0) {
                countOdds++;
            } else {
                countEvens++;
            }
        }
        return Math.min(countOdds, countEvens);
    }
}