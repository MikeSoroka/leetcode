# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        ppath = []
        qpath = []
        path = []

        def traverse(node):
            path.append(node)

            if node == p:
                for v in path:
                    ppath.append(v)
                if qpath:
                    return

            if node == q:
                for v in path:
                    qpath.append(v)
                if ppath:
                    return

            if node.left:
                traverse(node.left)
            if node.right:
                traverse(node.right)
            path.pop()

        traverse(root)

        i = 0
        while True:
            if i >= len(ppath) or i >= len(qpath) or ppath[i] != qpath[i]:
                return ppath[i - 1]

            i += 1
