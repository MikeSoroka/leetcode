class LRUCache:
    class Node():
        def __init__(self, key, val):
            self.prev = None
            self.next = None
            self.key = key
            self.val = val

    def __init__(self, capacity: int):
        self.map = {}
        self.cap = capacity
        self.head, self.tail = self.Node(None, None), self.Node(None, None)
        self.head.next, self.tail.prev = self.tail, self.head

    def _pop(self):
        last = self.tail.prev
        last.prev.next, last.next.prev = last.next, last.prev
        return last.key

    def _push(self, node):
        node.prev, node.next = self.head, self.head.next
        self.head.next.prev, self.head.next = node, node

    def _remove(self, node):
        node.prev.next, node.next.prev = node.next, node.prev

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1
        node = self.map[key]
        self._remove(node)
        self._push(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            node = self.map[key]
            node.val = value
            self._remove(node)
            self._push(node)

        else:
            newNode = self.Node(key, value)
            self.map[key] = newNode
            self._push(newNode)

            if len(self.map) > self.cap:
                lastkey = self._pop()
                self.map.pop(lastkey)
