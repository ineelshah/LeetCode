import java.util.regex.Pattern;

class WordDictionary {
    
    Map<Integer, ArrayList<String>> hmap;
    /** Initialize your data structure here. */
    public WordDictionary() {
        
        hmap = new HashMap<Integer, ArrayList<String>>();
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        ArrayList<String> list;
        
        if(hmap.get(word.length()) != null) 
            list = hmap.get(word.length());
        else 
            list = new ArrayList<String>();
        
        list.add(word);
        // We insert the string with same length together in one list
        hmap.put(word.length(), list);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        ArrayList<String> list;
        
        if(hmap.get(word.length()) != null) 
            list = hmap.get(word.length());
        else 
            return false;
        
        if(list.contains(word)) 
            return true;
        else 
        {
            Pattern regex = Pattern.compile(word);
            for (String s:list) {
                if (regex.matcher(s).matches()) 
                    return true;
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
 