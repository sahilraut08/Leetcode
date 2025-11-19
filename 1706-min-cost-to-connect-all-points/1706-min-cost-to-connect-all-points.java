class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        pq.add(new int[]{0,0});
        int totalCost = 0;
        int edges = 0;

        while(edges < n) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];

            if(visited[u]) continue;
            visited[u] = true;
            totalCost += cost;
            edges++;

            for(int v = 0; v < n; v++) {
                if(!visited[v]) {
                    int w = Math.abs(points[u][0] - points[v][0]) 
                            + Math.abs(points[u][1] - points[v][1]);
                    pq.add(new int[]{w, v});
                }
            }
        }
        return totalCost;
    }
}