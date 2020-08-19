class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        String[] ansWords = new String[words.length];
        String result = new String();
        
        int i =0;
        String temp = "a";
        
        
        for(String word: words)
        {
            
            StringBuffer sb = new StringBuffer(word);
            
            if(word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u") || word.startsWith("A") ||word.startsWith("E") ||word.startsWith("I") ||word.startsWith("O") ||word.startsWith("U"))
            {
                sb.append("ma");
            }
            else
            {
                char c = word.charAt(0);
                sb.delete(0, 1);
                sb.append(c);
                sb.append("ma");
            }
            
            result = result.concat(sb.toString().concat(temp).concat(" "));
            temp = temp.concat("a");
        }
        
        return result.substring(0, result.length() - 1);
    }
}