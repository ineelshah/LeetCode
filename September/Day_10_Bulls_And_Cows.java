class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> hmap1 = new HashMap<>();
        Map<Character, Integer> hmap2 = new HashMap<>();
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < guess.length(); i++) {
            if(guess.charAt(i) == secret.charAt(i)) {
                bulls++;
            }
            else {
                hmap1.put(guess.charAt(i), hmap1.getOrDefault(guess.charAt(i), 0) + 1);
                
                hmap2.put(secret.charAt(i), hmap2.getOrDefault(secret.charAt(i), 0) + 1);                
            }
        }
        
        
        for(Character key: hmap1.keySet()) {
            cows += Math.min(hmap1.getOrDefault(key, 0), hmap2.getOrDefault(key, 0));
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        
        return sb.toString();
        
        
    }
}