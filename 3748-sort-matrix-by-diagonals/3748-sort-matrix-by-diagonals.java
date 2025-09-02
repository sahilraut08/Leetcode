class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diag = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diag.putIfAbsent(key, new ArrayList<>());
                diag.get(key).add(grid[i][j]);
            }
        }
        for (int key : diag.keySet()) {
            List<Integer> values = diag.get(key);
            if (key >= 0) {
                values.sort(Collections.reverseOrder()); 
            } else {
                Collections.sort(values); 
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = diag.get(i - j).remove(0);
            }
        }

        return grid;
    }
}