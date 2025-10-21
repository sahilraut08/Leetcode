class Solution {
    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 0) {
            return 0;
        }
        
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[rows][cols];
        minHeap.offer(new int[]{0, 0, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int effort = current[0], curRow = current[1], curCol = current[2];
            
            if (visited[curRow][curCol]) continue;
            visited[curRow][curCol] = true;
            
            if (curRow == rows - 1 && curCol == cols - 1) return effort;
            
            for (int[] dir : directions) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    int newEffort = Math.max(effort, Math.abs(heights[newRow][newCol] - heights[curRow][curCol]));
                    minHeap.offer(new int[]{newEffort, newRow, newCol});
                }
            }
        }
        
        return 0;        
    }
}