class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int id = 2; 
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, id, n);
                    islandSize.put(id, size);
                    max = Math.max(max, size);
                    id++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int newSize = 1; 
                    for (int[] d : DIRS) {
                        int r = i + d[0], c = j + d[1];
                        if (r >= 0 && c >= 0 && r < n && c < n && grid[r][c] > 1) {
                            int islandId = grid[r][c];
                            if (seen.add(islandId)) {
                                newSize += islandSize.get(islandId);
                            }
                        }
                    }
                    max = Math.max(max, newSize);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int r, int c, int id, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1)
            return 0;
        grid[r][c] = id;
        int count = 1;
        for (int[] d : DIRS) {
            count += dfs(grid, r + d[0], c + d[1], id, n);
        }
        return count;
    }
}
