/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        TreeNode node;
        int row;  
        int col;  

        public Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            map.computeIfAbsent(curr.row, k -> new ArrayList<>()).add(curr);

            if (curr.node.left != null)
                q.add(new Pair(curr.node.left, curr.row - 1, curr.col + 1));
            if (curr.node.right != null)
                q.add(new Pair(curr.node.right, curr.row + 1, curr.col + 1));
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<Pair> group : map.values()) {
            group.sort((a, b) -> {
                if (a.col == b.col)
                    return Integer.compare(a.node.val, b.node.val);
                return Integer.compare(a.col, b.col);
            });
            List<Integer> col = new ArrayList<>();
            for (Pair p : group) col.add(p.node.val);
            res.add(col);
        }

        return res;
    }
}