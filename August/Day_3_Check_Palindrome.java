class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for(Character c: str.toCharArray())
        {
            if((c >= 'a' && c <= 'z' )||( c >= '0' && c <= '9'))
                sb.append(c);                
        }
        
        String ss = sb.toString();
        
        int n = ss.length() - 1;
        for(int i = 0; i < n; i++)
        {
            if(ss.charAt(i) != ss.charAt(n - i))
                return false;
        }
        
        return true;
        
    }
}