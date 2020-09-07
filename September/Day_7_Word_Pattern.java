class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] patternArr = pattern.toCharArray();
        String[] strArr = str.split(" ");
        
        if(patternArr.length != strArr.length)
            return false;
        Set<Character> set = new HashSet<>();
        Map<String, Character> hmap = new HashMap<>();
        for(int i = 0; i < strArr.length; i++) {
            if(!hmap.containsKey(strArr[i])) {
                if(set.contains(patternArr[i]))
                    return false;
                hmap.put(strArr[i], patternArr[i]);
                set.add(patternArr[i]);
            }
            else {
                Character existing = hmap.get(strArr[i]);
                if(existing != (patternArr[i]))
                    return false;
            }
        }
        return true;
        
    }
}