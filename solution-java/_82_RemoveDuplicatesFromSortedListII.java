/*
Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/
public class _82_RemoveDuplicatesFromSortedListII {
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(head.val - 1), tail = dummy;
        ListNode p = head;
        int lastVal = dummy.val;
        while (p != null) {
            ListNode temp = p.next;
            if (p.val != lastVal && (p.next == null || p.val != p.next.val)) {
                tail.next = p;
                tail = p;
            }
            lastVal = p.val;
            p = temp;
        }
        tail.next = null;
        return dummy.next;
    }
}