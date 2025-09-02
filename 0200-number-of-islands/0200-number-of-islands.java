class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int []> q = new LinkedList<>();
        int [][] dirs = new int [][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, dirs, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int [][] dirs, int m, int n) {
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        //logic
        grid[i][j] = '0';
        for(int [] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, nr, nc, dirs, m, n);
        }
    }
}