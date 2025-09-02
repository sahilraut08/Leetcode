class Solution {
    public int minFallingPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int n = grid.length;
        for(int i = n-2; i>=0; i--) {
            for(int j = 0; j<n; j++) {
                int min = Integer.MAX_VALUE;
                for(int k = 0; k<n; k++) {
                    if(j!=k) {
                        min = Math.min(grid[i+1][k], min);
                    }
                }
                grid[i][j] = grid[i][j] + min;
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++) {
            result = Math.min(grid[0][i], result);
        }
        return result;
    }
}