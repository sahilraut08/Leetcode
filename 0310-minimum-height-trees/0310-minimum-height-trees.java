class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        int[] indegrees = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            indegrees[u]++;
            indegrees[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(indegrees[i] == 1) {
                q.add(i);
            }
        }

        int remainingNodes = n;
        while(remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;
            for(int i = 0; i < size; i++) {
                int curr = q.poll();
                List<Integer> currEdges = adjList.get(curr);
                for(int e : currEdges) {
                    indegrees[e]--;
                    if(indegrees[e] == 1) {
                        q.add(e);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }
}