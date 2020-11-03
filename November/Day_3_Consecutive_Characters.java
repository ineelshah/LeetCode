class Solution {
    public int maxPower(String s) {
        int max = 0;
        
        for(int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            int count = 0;
            while(i < s.length() && s.charAt(i) == c) {
                count++;
                i++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}