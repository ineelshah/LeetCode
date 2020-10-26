class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int m = query_row + 1;
        int n = query_row + 2;
        double[][] dp = new double[m][n];
        dp[0][0] = poured;
        for(int i = 1; i < m; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] = (dp[i - 1][j] - 1)/2 >= 0 ? (dp[i - 1][j] - 1)/2 : 0;
                } else {
                    double a = 0, b = 0;
                    a = (dp[i - 1][j - 1] - 1)/2 >= 0.0 ? (dp[i - 1][j - 1] - 1)/2 : 0;
                    b = (dp[i - 1][j] - 1)/2 >= 0.0 ? (dp[i - 1][j] - 1)/2 : 0;
                    // System.out.println(a + " " + b);
                    dp[i][j] = a + b;
                }
            }
        }
        
        if(dp[query_row][query_glass] > 1.0) 
            return (double)1;
        
        return dp[query_row][query_glass];
    }
}