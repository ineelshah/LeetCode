class Solution {
    public int orangesRotting(int[][] grid) {
        Map<Integer[], Integer> hmap = new HashMap<>();
        
        int count = 0;
        
        for(int k = 0; k <= grid.length * grid[0].length; k++) // Iterating through the matrix k number of times!
        {
            // Setting vulnerable positions to -100
            for(int i = 0; i < grid.length; i++)
            {
                for(int j = 0; j < grid[0].length; j++)
                {
                    if(grid[i][j] == 1) {
                        if(((j > 0) && grid[i][j - 1] == 2) 
                           || ((i > 0) && grid[i - 1][j] == 2) 
                           || ((i < grid.length - 1) && grid[i + 1][j] == 2) 
                           || ((j < grid[0].length - 1) && grid[i][j + 1] == 2)) {
                            grid[i][j] = -100;
                        }
                    }
                }
            }
            
            boolean foundNegValue = false; // To check if any modifications were found
            for(int i = 0; i < grid.length; i++)
            {
                for(int j = 0; j < grid[0].length; j++)
                {
                    if(grid[i][j] == -100)
                    {
                        grid[i][j] = 2;
                        foundNegValue = true;
                    }
                }
            }
            
            boolean foundOne= false;
            
            for(int i = 0; i < grid.length; i++)
            {
                for(int j = 0; j < grid[0].length; j++)
                {
                    if(grid[i][j] == 1)
                    {
                        foundOne = true;
                    }
                }
            }
            
            if(foundNegValue)
                count++;
            
            if(foundOne == false){
                return count;
            }
            
        }
        
        return -1;
    }
}