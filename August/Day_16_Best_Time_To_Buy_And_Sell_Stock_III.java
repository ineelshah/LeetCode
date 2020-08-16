class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[3][prices.length];
        if(prices.length == 0) return 0;
        
        
        
        
        
        for(int i = 1; i <= 2; i++)
        {
            for(int j = 1; j < prices.length; j++)
            {
                for(int m = 0; m < j; m++)
                {
                    int temp = prices[j] - prices[m] + dp[i-1][m];
                    //System.out.println(temp);
                    dp[i][j] = Math.max(Math.max(dp[i][j - 1], temp), dp[i][j]);
                }
                
            }
        }
        /*
        for(int i = 0; i <= 2; i++)
        {
            for(int j = 0; j < prices.length; j++)
            {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        */
        
        return dp[2][prices.length - 1];
    }
}