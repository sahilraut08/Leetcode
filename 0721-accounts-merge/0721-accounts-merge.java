class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet (int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent (int node) {
        if (node == parent.get(node)) return node;
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public void union (int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);

        int parentUSize = size.get(parentU);
        int parentVSize = size.get(parentV);

        if (parentUSize < parentVSize) {
            parent.set(parentU, parentV);
            size.set(parentV, parentUSize + parentVSize);
        } else {
            parent.set(parentV, parentU);
            size.set(parentU, parentUSize + parentVSize);
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mailToID = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mailToID.containsKey(mail)) {
                    mailToID.put(mail, i);
                } else {
                    ds.union(i, mailToID.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<>();

        for (String mail : mailToID.keySet()) {
            int node = ds.findParent(mailToID.get(mail));
            mergedMail[node].add(mail);
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String mail : mergedMail[i]) {
                temp.add(mail);
            }
            result.add(temp);
        }

        return result;
    }
}