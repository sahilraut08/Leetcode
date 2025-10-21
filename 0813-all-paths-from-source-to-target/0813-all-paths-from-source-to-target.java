class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, res, path, graph);
        return res;
    }

    public void dfs(int u, List<List<Integer>> res, List<Integer> path, int[][] graph)
    {
        if(u==graph.length-1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int v:graph[u]) {
            path.add(v);
            dfs(v, res, path, graph);
            path.remove(path.size()-1);
        }
    }
}