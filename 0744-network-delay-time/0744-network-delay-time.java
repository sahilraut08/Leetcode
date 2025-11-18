class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for(int[] time : times) {
            int start = time[0];
            int end = time[1];
            int weight = time[2];

            map.putIfAbsent(start, new HashMap<>());
            map.get(start).put(end, weight);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k,0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curNode = cur[0];
            int curWeight = cur[1];

            for(int nei : map.getOrDefault(curNode, new HashMap<>()).keySet()) {
                int neiWeight = map.get(curNode).get(nei);
                if(curWeight + neiWeight < dist[nei]) {
                    dist[nei] = curWeight + neiWeight;
                    q.add(new int[]{nei, curWeight + neiWeight});
                }
            }
        }

        int result = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] > result) {
                result = Math.max(result, dist[i]);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}