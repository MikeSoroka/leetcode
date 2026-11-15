# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def mapToStr(self, m):
        res = []
        for key in m:
            new_str = str(key) + ":" + str(m[key])
            res.append(new_str)

        return ';'.join(res)

    def strToMap(self, s):
        items = s.split(';')
        res = {}
        for item in items:
            k, v = item.split(':')
            res[int(k)] = int(v)

        return res

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        vals = {}

        # n -> 2n + 1; 2n + 2
        # k <- (k - 1) // 2

        # n -> kn + 1, kn + 2, ... , kn + k
        # child <- (n + 1 - k) / k

        def traverse(node, index):
            if node.left:
                vals[index * 2 + 1] = node.left.val
                traverse(node.left, index * 2 + 1)
            if node.right:
                vals[index * 2 + 2] = node.right.val
                traverse(node.right, index * 2 + 2)

        if not root:
            return ""
        else:
            vals[0] = root.val
            traverse(root, 0)
        return self.mapToStr(vals)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return

        m = self.strToMap(data)
        tree = {}
        root = TreeNode(m[0])
        tree[0] = root
        for key in m:
            if key == 0:
                continue
            node = TreeNode(m[key])
            tree[key] = node

            par_ind = (key - 1) // 2
            parent = tree[par_ind]

            if key - par_ind * 2 == 1:
                parent.left = node
            else:
                parent.right = node

        return root

# 0:1;1:val;4:val;5:val;7:val;8:val;9:val

# 0:1;1:2;2:3;5:4;6:5
# 0:1,


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))