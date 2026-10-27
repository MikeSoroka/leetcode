/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        var resHead = new Node(head.val);
        var map = new HashMap<Node, Node>();
        map.put(head, resHead);
        var prev = resHead;

        for(var cur = head; cur != null; cur = cur.next) {
            if (cur == head) {
                continue;
            }
            var newNode = new Node(cur.val);
            prev.next = newNode;
            prev = newNode;
            map.put(cur, prev);
        }

        for(var cur = head; cur != null; cur = cur.next) {
            map.get(cur).random = cur.random == null ? null : map.get(cur.random);
        }

        return resHead;
    }
}