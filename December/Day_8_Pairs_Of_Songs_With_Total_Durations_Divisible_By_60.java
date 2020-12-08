class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] modulus = new int[60];
        int count = 0;
        for(int t: time) {
            int mod = t % 60;
            if(mod == 0) {
                count += modulus[0];
            } else {
                count += modulus[60 - mod];
            }
            modulus[mod]++;
        }
        return count;
    }    
}