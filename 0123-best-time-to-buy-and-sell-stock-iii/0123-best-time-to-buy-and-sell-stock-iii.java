class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for(int idx = n-1; idx >=0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    if(buy == 1) {
                        dp[idx][buy][cap] = Math.max((-prices[idx] + dp[idx + 1][0][cap]), dp[idx + 1][1][cap]);
                    } else {
                        dp[idx][buy][cap] = Math.max((prices[idx] + dp[idx + 1][1][cap - 1]), dp[idx + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
    // private int helper(int idx, int buy, int[] prices, int cap, int[][][] dp) {
    //     if(idx == prices.length || cap == 0) return 0;
    //     if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
    //     if(buy == 1) {
    //         return dp[idx][buy][cap] = Math.max((-prices[idx] + helper(idx + 1, 0, prices, cap, dp)),
    //                         0 + helper(idx + 1, 1, prices, cap, dp));
    //     }
    //     return dp[idx][buy][cap] = Math.max((prices[idx] + helper(idx + 1, 1, prices, cap - 1, dp)), 
    //                     0 + helper(idx + 1, 0, prices, cap, dp));
    // }
}