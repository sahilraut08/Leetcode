class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prevCol = image[sr][sc];
        if (prevCol == color) return image;

        dfs(image, sr, sc, color, prevCol);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int prevCol) {
        image[sr][sc] = color;

        int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

        for (int[] d : dirs) {
            int nr = sr + d[0];
            int nc = sc + d[1];

            if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length 
                && image[nr][nc] == prevCol) {
                dfs(image, nr, nc, color, prevCol);
            }
        }
    }
}