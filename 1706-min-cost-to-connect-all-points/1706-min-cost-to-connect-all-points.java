class Solution {

    class DSU {
        int[] parent, size;
        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x) {
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if(px == py) return;
            if(size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int w = Math.abs(points[i][0] - points[j][0])
                      + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i,j,w});
            }
        }

        edges.sort((a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(n);
        int cost = 0;

        for (int[] e : edges) {
            if (dsu.find(e[0]) != dsu.find(e[1])) {
                dsu.union(e[0], e[1]);
                cost += e[2];
            }
        }

        return cost;
    }
}