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
    TreeNode curr;
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode newRight = root.right;
        curr=root;
        helper(root.left);
        root.left = null;
        helper(newRight);
    }

    private void helper(TreeNode root) {
        if(root==null) return;
        TreeNode newRight = root.right;
        curr.right = root;
        curr = root;
        helper(root.left);
        root.left = null;
        helper(newRight);
    }
}

// class Solution {
//     TreeNode curr;
//     public void flatten(TreeNode root) {
//         if(root==null) return;
//         curr=root;
//         TreeNode newRight = root.right;
//         helper(root.left);
//         root.left = null;
//         helper(newRight);
//     }
//     private void helper(TreeNode root) {
//         if(root==null) return;
//         curr.right = root;
//         curr = root;
//         TreeNode newRight = root.right;
//         helper(root.left);
//         root.left = null;
//         helper(newRight);
//     }
// }