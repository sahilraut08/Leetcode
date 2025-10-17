class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int [] dp = new int[n+1];
        for(int i = 1; i <= m; i++) {
            int diagUp = 0;
            for(int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    int temp = dp[j];
                    dp[j] = 1 + Math.min(dp[j], Math.min(diagUp, dp[j-1]));
                    max = Math.max(max, dp[j]);
                    diagUp = temp;
                } else {
                    dp[j] = 0;
                }
            }
        }
        return max*max;
    }
}