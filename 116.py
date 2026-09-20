"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None
        def bfs(level):
            if not level:
                return
            new = []
            for i in range(len(level) - 1):
                level[i].next = level[i + 1]
                if not level[i].left:
                    continue
                new.append(level[i].left)
                new.append(level[i].right)

            level[-1].next = None
            if level[-1].left:
                new.append(level[-1].left)
                new.append(level[-1].right)

            bfs(new)

        bfs([root])
        return root