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
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if(root==null) return result;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0; i<size; i++){
//                 TreeNode curr = q.poll();
//                 if(i==size-1) result.add(curr.val);
//                 if(curr.left!=null) q.add(curr.left);
//                 if(curr.right!=null) q.add(curr.right);
//             }
//         }
//         return result;
//     }
// }

class Solution {
    private List<Integer> result=new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewFinder(root,0);
        return result;
        
    }
    private void rightSideViewFinder(TreeNode newRoot,int level){
        if(newRoot==null) return;
        if(level==result.size()) result.add(newRoot.val);

        if(newRoot.right!=null) rightSideViewFinder(newRoot.right,level+1);
        if(newRoot.left!=null) rightSideViewFinder(newRoot.left,level+1);
    }
}