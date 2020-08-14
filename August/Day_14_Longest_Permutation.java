class Solution {
    public int longestPalindrome(String s) {
        // GREEDY APPROACH:
        int[] lower = new int[26];
        int[] upper = new int[26];
        
        for(Character c: s.toCharArray())
        {
            int a = c - 'a';
            int b = c - 'A';
            if(a >= 0 && a < 26)
                lower[a]++;
            if(b >= 0 && b < 26)
                upper[b]++;
        }
        
        
        int count = 0;
        boolean hasOdd = false;
        for(int i = 0; i < 26; i++)
        {
            count += lower[i] / 2 * 2;
            count += upper[i] / 2 * 2;
            if(lower[i] % 2 != 0 || upper[i] % 2 != 0)
                hasOdd = true;
        }
        
        return hasOdd ? count + 1 : count;
        
        
    }
}