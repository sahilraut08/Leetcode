class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //Building the graph
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            Double val = values[i];
            
            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, val);
            graph.get(v).put(u, 1/val);
        }

        double[] results = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end  = queries.get(i).get(1);
            HashSet<String> visited = new HashSet<>();
            results[i] = dfs(start, end, visited, graph, 1.0);
        }
        return results;
    }
    private double dfs(String start, String end, HashSet<String> visited, HashMap<String, HashMap<String, Double>> graph, double product) {
        if(!graph.containsKey(start) || !graph.containsKey(end)) return -1.0;
        if(start.equals(end)) return product;
        visited.add(start);
        for(Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if(!visited.contains(neighbour.getKey())) {
                double result = dfs(neighbour.getKey(), end, visited, graph, product * neighbour.getValue());
                if(result != -1.0) return result;
            }
        }
        return -1.0;
    }
}