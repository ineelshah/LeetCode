class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] distribution = new int[num_people];
        
        int remainingCorpus = candies;
        int cycleNumber = 0;
        int i = 0;
        while(remainingCorpus > 0)
        {
            if(i == num_people)
            {
                i = 0;
                cycleNumber++;
            }
            
            int cycleThreshold = cycleNumber * num_people;
            
            int numberOfCandies = (i + 1) + cycleThreshold;
            
            System.out.println(i + " " + numberOfCandies);
            
            distribution[i] += Math.min(numberOfCandies, remainingCorpus);
            remainingCorpus -= numberOfCandies;
            
            i++;
            
        }
        
        return distribution;
        
        
    }
}