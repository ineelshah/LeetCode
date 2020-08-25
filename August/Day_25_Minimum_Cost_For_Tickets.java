class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int oneDay = costs[0];
        int sevenDays = costs[1];
        int thirtyDays = costs[2];
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = oneDay;
        
        boolean[] travelsOnThisDay = new boolean[n + 1];
        
        for(int day: days)
        {
            travelsOnThisDay[day] = true;
        }
        
        for(int day = 1; day <= n; day++)
        {
            int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
            
            if(!travelsOnThisDay[day]) {
                dp[day] = dp[day-1];
            }
            
            else {
                if(day > 30)
                {
                    
                    a = dp[day - 1] + oneDay;
                    b = dp[day - 7] + sevenDays;
                    c = dp[day - 30] + thirtyDays;

                    dp[day] = Math.min(a, Math.min(b, c));
                }
                else if (day > 7)
                {
                    a = dp[day - 1] + oneDay;
                    b = dp[day - 7] + sevenDays;
                    c = thirtyDays;
                    dp[day] = Math.min(a, Math.min(b, c));
                }
                else
                {
                    a = dp[day - 1] + oneDay;
                    b = sevenDays;
                    c = thirtyDays;
                    dp[day] = Math.min(a, Math.min(b, c));
                }
            }
        }
        
        return dp[n];
    }
}