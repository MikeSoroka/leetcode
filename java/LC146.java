class LRUCache {
    class Node {
        int key, val;
        Node prev, next;

        Node() {
            this.key = -1;
            this.val = -1;
            this.prev = null;
            this.next = null;
        }

        Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.prev = null;
            this.next = null;
        }
    }

    Node head, tail;
    int capacity;
    HashMap<Integer, Node> data;

    public int remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        return node.key;
    }

    public void push(Node node) {
        node.next = this.head.next;
        node.next.prev = node;
        node.prev = head;
        this.head.next = node;
    }

    public int pop() {
        Node last = this.tail.prev;
        this.remove(last);

        return last.key;
    }

    public boolean isEmpty() {
        return this.head.next == this.tail;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();

        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.data = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (!this.data.containsKey(key)) {
            return -1;
        }
        Node node = this.data.get(key);
        this.remove(node);
        this.push(node);

        return node.val;
    }

    public void put(int key, int value) {
        Node node;
        node = new Node(key, value);

        if (!this.data.containsKey(key) && this.data.size() == this.capacity) {
            int removeKey = this.pop();
            this.data.remove(removeKey);
        }
        else if (this.data.containsKey(key)) {
            this.remove(this.data.get(key));
        }

        this.push(node);
        this.data.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */