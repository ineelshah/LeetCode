class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> prevLevel = new ArrayList<>();
        List<Integer> currLevel = new ArrayList<>();
        
        if(rowIndex == 0){
            currLevel.add(1);
            return currLevel;
        }
        
        int currCount = 0;
        
        while(currCount < rowIndex)
        {
            
            currLevel.add(1);
            for(int i = 0; i < prevLevel.size() - 1; i++)
            {
                int sum = prevLevel.get(i) + prevLevel.get(i + 1);
                currLevel.add(sum);
            }
            currLevel.add(1);
            
            prevLevel.clear();
            prevLevel.addAll(currLevel);
            
            if(currCount == rowIndex - 1)
                return currLevel;
            
            currLevel.clear();
            currCount++;
        }
        return currLevel;
    }
}