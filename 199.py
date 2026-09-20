# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode | None) -> list[int]:
        res = []

        def newLevel(current):
            if not current:
                return
            new = []
            res.append(current[-1].val)
            for node in current:
                if node.left:
                    new.append(node.left)
                if node.right:
                    new.append(node.right)

            newLevel(new)

        if not root:
            return []
        newLevel([root])

        return res
