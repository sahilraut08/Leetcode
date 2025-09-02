class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] n:dp) {
            Arrays.fill(n, -1);
        }
        return helper(prices, 0, 0, dp);
    }
    private int helper(int[] prices, int stock, int idx, int[][] dp) {
        if(idx >= prices.length) return 0;

        if(dp[idx][stock] != -1) return dp[idx][stock];

        int profit1 = 0;
        int profit2 = 0;

        if(stock == 0) {
            profit1 = helper(prices, 1, idx + 1, dp) - prices[idx];
            profit2 = helper(prices, 0, idx + 1, dp);
        } else {
            profit1 = helper(prices, 0, idx + 2, dp) + prices[idx];
            profit2 = helper(prices, 1, idx + 1, dp);
        }
        dp[idx][stock] = Math.max(profit1, profit2);
        return dp[idx][stock];
    }
}