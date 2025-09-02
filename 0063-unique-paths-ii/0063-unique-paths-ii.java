class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for(int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) curr[j] = 0;
                else if(i == 0 && j == 0) curr[j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = dp[j];
                    if(j > 0) left = curr[j - 1];
                    curr[j] = up + left;
                }
            }
            dp = curr;
        }
        return dp[n - 1];
    }
}