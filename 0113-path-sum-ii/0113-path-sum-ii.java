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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int target, int currSum, List<Integer> path) {
        if(root == null) return;
        path.add(root.val);
        currSum += root.val;
        if(root.left == null && root.right == null && currSum == target) {
            result.add(new ArrayList<>(path));
        }
        helper(root.left, target, currSum, path);
        helper(root.right, target, currSum, path);
        path.remove(path.size() - 1);
    }
}