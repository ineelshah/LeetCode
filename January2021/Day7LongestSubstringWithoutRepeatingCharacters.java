class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> hset = new HashSet<>();
        
        int currCount = 0;
        int maxCount = 0;
        int start = 0;
        int i = 0;
        while(i < s.length() && start < s.length()) {
            if(!hset.contains(s.charAt(i))) {
                hset.add(s.charAt(i));
                i++;
                currCount = i - start;
                maxCount = Math.max(currCount, maxCount);
            } else {
                hset.remove(s.charAt(start));    
                start++;                 
            }
        }
        return maxCount;
    }
}