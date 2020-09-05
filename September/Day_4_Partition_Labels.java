class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> labels = new ArrayList<>();
        int[] lastIndexes= new int[26];
        for(int i = 0; i < S.length(); i++) {
            lastIndexes[S.charAt(i) - 'a'] = i;
        }
        
        
        int currLabelStartIndex = 0;
        while(currLabelStartIndex < S.length()) {
            int end = lastIndexes[S.charAt(currLabelStartIndex) - 'a'];
            int currCharIndex = currLabelStartIndex;
            
            while(currCharIndex != end) {
                end = Math.max(end, lastIndexes[S.charAt(currCharIndex++) - 'a']);
            }
            
            labels.add(currCharIndex - currLabelStartIndex + 1);
            
            currLabelStartIndex = currCharIndex + 1;
            
        }
        return labels;
    }
}