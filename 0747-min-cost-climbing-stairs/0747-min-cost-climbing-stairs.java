class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return minHelper(cost, n, dp);
    }

    public int minHelper(int[] cost, int n, int[] dp) {
        if (dp[n] != -1) return dp[n];
        if (n <= 1) return dp[n] = 0;
        if (n == 2) return dp[n] = Math.min(cost[0], cost[1]);
        
        int costOneStep = minHelper(cost, n - 1, dp) + cost[n - 1];
        int costTwoSteps = minHelper(cost, n - 2, dp) + cost[n - 2];
        
        return dp[n] = Math.min(costOneStep, costTwoSteps);
    }
}
