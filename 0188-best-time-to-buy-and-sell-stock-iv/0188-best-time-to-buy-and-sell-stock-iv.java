class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k+1];
        for(int idx = n-1; idx >=0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= k; cap++) {
                    if(buy == 1) {
                        dp[idx][buy][cap] = Math.max((-prices[idx] + dp[idx + 1][0][cap]), dp[idx + 1][1][cap]);
                    } else {
                        dp[idx][buy][cap] = Math.max((prices[idx] + dp[idx + 1][1][cap - 1]), dp[idx + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}