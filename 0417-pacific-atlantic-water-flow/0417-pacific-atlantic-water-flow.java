class Solution {
    private int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int []> pq = new LinkedList<>();
        Queue<int []> aq = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            pq.add(new int[]{i, 0});
            aq.add(new int[]{i, n - 1});
        }

        for(int i = 0; i < n; i++) {
            pq.add(new int[]{0, i});
            aq.add(new int[]{m - 1, i});
        }

        bfs(pq, pacific, heights, m, n);
        bfs(aq, atlantic, heights, m, n);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int []> q, boolean[][] visited, int[][] heights, int m, int n) {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            visited[row][col] = true;
            for(int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >=0 && nc >= 0 && nr < m && nc < n && heights[nr][nc] >= heights[row][col] && !visited[nr][nc]) {
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}