class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], a -> new ArrayList<>())
                 .add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});

        int[][] visited = new int[n][k + 2];
        for (int[] arr : visited) Arrays.fill(arr, Integer.MAX_VALUE);
        visited[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], city = cur[1], stops = cur[2];

            if (city == dst) return cost;
            if (stops > k) continue;

            if (!graph.containsKey(city)) continue;
            for (int[] next : graph.get(city)) {
                int nextCity = next[0];
                int nextCost = cost + next[1];

                if (nextCost < visited[nextCity][stops + 1]) {
                    visited[nextCity][stops + 1] = nextCost;
                    pq.offer(new int[]{nextCost, nextCity, stops + 1});
                }
            }
        }

        return -1;
    }
}