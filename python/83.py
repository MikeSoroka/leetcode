class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode | None) -> ListNode | None:
        if not head:
            return None
        current = head
        while current.next:
            while current.next and current.val == current.next.val:
                current.next = current.next.next
            if current.next:
                current = current.next

        return head
