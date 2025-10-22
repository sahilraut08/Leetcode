class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new ArrayList<>());

                if (i > 1) {
                    graph.get(acc.get(1)).add(email);
                    graph.get(email).add(acc.get(1));
                }
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> merged = new ArrayList<>();
                Queue<String> q = new LinkedList<>();
                q.offer(email);
                visited.add(email);

                while (!q.isEmpty()) {
                    String cur = q.poll();
                    merged.add(cur);
                    for (String next : graph.get(cur)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }

                Collections.sort(merged);
                merged.add(0, emailToName.get(email));
                res.add(merged);
            }
        }

        return res;
    }
}