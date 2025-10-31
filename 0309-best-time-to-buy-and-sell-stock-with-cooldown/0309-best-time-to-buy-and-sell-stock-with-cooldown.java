class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for(int idx = n-1; idx >= 0; idx--) {
            for(int stock = 0; stock <= 1; stock++) {
                int profit1 = 0;
                int profit2 = 0;
                if(stock == 0) {
                    profit1 = dp[idx+1][1] - prices[idx];
                    profit2 = dp[idx+1][0];
                } else {
                    profit1 = dp[idx+2][0] + prices[idx];
                    profit2 = dp[idx+1][1];
                }
                dp[idx][stock] = Math.max(profit1, profit2);
            }
        }
        return dp[0][0];
    }
    // private int helper(int[] prices, int stock, int idx, int[][] dp) {
    //     if(idx >= prices.length) return 0;

    //     if(dp[idx][stock] != -1) return dp[idx][stock];

    //     int profit1 = 0;
    //     int profit2 = 0;

    //     if(stock == 0) {
    //         profit1 = helper(prices, 1, idx + 1, dp) - prices[idx];
    //         profit2 = helper(prices, 0, idx + 1, dp);
    //     } else {
    //         profit1 = helper(prices, 0, idx + 2, dp) + prices[idx];
    //         profit2 = helper(prices, 1, idx + 1, dp);
    //     }
    //     dp[idx][stock] = Math.max(profit1, profit2);
    //     return dp[idx][stock];
    // }
}