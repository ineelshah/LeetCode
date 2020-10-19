class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Set<String> hset = new HashSet<>();
        List<String> ans = new ArrayList<>();
        
        for(int i = 0; i <= s.length() - 10; i++)
        {
            String temp = s.substring(i, i + 10);
            if(!hset.contains(temp))
                hset.add(temp);
            else if(!ans.contains(temp))
                ans.add(temp);
        }
        
        return ans;
    }
}