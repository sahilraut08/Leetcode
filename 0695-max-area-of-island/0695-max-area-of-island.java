class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int [][] dirs = new int [][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int area = 0;
                if(grid[i][j] == 1) {
                    area++;
                    q.add(new int[] {i, j});
                    grid[i][j] = 0;
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir : dirs) {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                                area++;
                                q.add(new int[] {nr, nc});
                                grid[nr][nc] = 0;
                            }
                        }
                    }
                }
                max = Math.max(max, area);
            } 
        }
        return max;
    }
}