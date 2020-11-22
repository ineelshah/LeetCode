class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> hset = new HashSet<>();
        String[] arr = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String word: words) {
            StringBuilder sb = new StringBuilder();            
            for(Character c: word.toCharArray()) {
                sb.append(arr[c - 'a']);
            }
            hset.add(sb.toString());
        }
        return hset.size();
    }
}