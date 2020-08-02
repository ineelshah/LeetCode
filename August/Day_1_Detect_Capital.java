class Solution {
    public boolean detectCapitalUse(String word) {
        
        int countUpper = 0;
        for(Character c: word.toCharArray())
        {
            if(Character.isUpperCase(c))
                countUpper++;
        }
        
        if(countUpper == 0)
            return true;
        
        if(word.length() == countUpper)
            return true;
        
        if(countUpper == 1 && Character.isUpperCase(word.charAt(0)))
           return true;
           
        return false;
            
        
    }
}