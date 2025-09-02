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
    private int moves = 0;
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftCoins = dfs(node.left);
        int rightCoins = dfs(node.right);
        moves += Math.abs(leftCoins) + Math.abs(rightCoins);
        return node.val + leftCoins + rightCoins - 1;
    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
}