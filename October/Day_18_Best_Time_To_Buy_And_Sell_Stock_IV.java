class Solution {
    
    public int unlimitedTransactions(int[] prices)
    {
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] > prices[i-1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
    
    
    
    public int maxProfit(int k, int[] prices) {
        
        
        if(prices.length == 0) return 0;
        
        if(k > prices.length)
            return unlimitedTransactions(prices);
        
        
        
        int[][] dp = new int[2][prices.length];
        
        for(int i = 1; i <= k; i++)
        {
            for(int j = 1; j < prices.length; j++)
            {
                for(int m = 0; m < j; m++)
                {
                    int temp = prices[j] - prices[m] + dp[0][m];
                    dp[1][j] = Math.max(Math.max(dp[1][j - 1], dp[1][j]), temp);
                }
            }
            
            
            for(int p = 0; p < prices.length; p++)
            {
                dp[0][p] = dp[1][p];
            }
        }
        return dp[1][prices.length - 1];
    }
    
    
}