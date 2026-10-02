class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode | None) -> ListNode | None:
        prev = None
        curr = head
        while curr and curr.next:
            if curr.val == curr.next.val:
                v = curr.val
                if v == head.val:
                    head = None
                while curr and curr.val == v:
                    curr = curr.next
                if not prev:
                    head = curr
                else:
                    prev.next = curr
            else:
                prev = curr
                if curr.next:
                    curr = curr.next

        return head
