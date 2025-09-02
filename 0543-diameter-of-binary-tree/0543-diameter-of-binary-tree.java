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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode root) {
        //base case
        if(root==null) return 0;
        //left traversal
        int left = helper(root.left);
        //right
        int right = helper(root.right);
        // addition of left and right
        this.max=Math.max(left+right, this.max);
        return Math.max(left, right) + 1;
    }
}