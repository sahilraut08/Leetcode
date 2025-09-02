class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> 
            a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int n = points.length;
        int solution = 0;

        for (int i = 0; i < n; i++) {
            int[] c = points[i];
            int currentMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int[] t = points[j];
                if (c[1] < t[1]) continue;
                if (currentMax >= t[1]) continue;
                currentMax = Math.max(currentMax, t[1]);
                solution++;
            }
        }
        return solution;
    }
}