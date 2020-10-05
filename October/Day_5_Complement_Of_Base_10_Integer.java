class Solution {
    public int bitwiseComplement(int N) {
        if(N == 0)
            return 1;        
        int biggerPower = 0;
        int i = 0;
        while(biggerPower < N) {
            biggerPower = (int)Math.pow(2, i) - 1;
            i++;
        }
        int ans = biggerPower ^ N;        
        return ans;        
    }
}