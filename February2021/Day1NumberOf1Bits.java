public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        int i = 1;
        while(i <= 32) {
            if((n & mask) != 0) count++;
            mask = mask << 1;
            i++;
        }
        return count;
    }
}