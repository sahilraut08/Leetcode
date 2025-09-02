# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, None, None)

    def helper(self, root, minVal, maxVal):
        # base
        if root == None: return True

        # logic
        if minVal != None and root.val <= minVal:
            return False
        if maxVal != None and root.val >= maxVal:
            return False
        
        return self.helper(root.left, minVal, root.val) and self.helper(root.right, root.val, maxVal)