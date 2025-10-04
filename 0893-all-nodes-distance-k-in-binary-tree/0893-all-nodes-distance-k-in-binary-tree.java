/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        getParent(root, map);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int lvl = 0;
        HashSet<TreeNode> set = new HashSet<>();
        set.add(target);
        while (!q.isEmpty()) {

            int size = q.size();
            if (lvl == k)
                break;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();

                if (curr.left != null && !set.contains(curr.left)) {
                    q.add(curr.left);
                    set.add(curr.left);
                }

                if (curr.right != null && !set.contains(curr.right) ) {
                    q.add(curr.right);
                    set.add(curr.right);
                }

                TreeNode parent = map.get(curr);
                if (!set.contains(parent) && parent != null ) {
                    q.add(parent);
                    set.add(parent);
                }
            }
            lvl++;
        }

        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            list.add(curr.val);
        }
        return list;
    }

    public void getParent(TreeNode root, HashMap<TreeNode, TreeNode> map) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();

                if (curr.left != null) {
                    q.add(curr.left);
                    map.put(curr.left, curr);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                    map.put(curr.right, curr);
                }
            }
        }
    }
}