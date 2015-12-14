/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.
*/
public class _19_RemoveNthNodeFromEndOfList {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head, pre = null;
        int i = 1;
        while (fast.next != null && i++ < n) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (slow == head) {
            head = slow.next;
        } else {
            pre = slow.next;
        }
        return head;
    }
}