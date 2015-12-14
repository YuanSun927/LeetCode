/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
public class _24_SwapNodesInPairs {
    
    // Submission Result: Time Limit Exceeded 
    public ListNode swapPairs1(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode p = head.next;
        head.next = head.next.next;
        p.next = head;
        head = p;
        p = head.next.next;
        ListNode pre = head.next;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            p.next = p.next.next;
            q.next = p;
            pre.next = q;
            p = p.next;
            pre = p;
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode p = head.next;
        head.next = head.next.next;
        p.next = head;
        head = p;
        p = head.next.next;
        ListNode pre = head.next;
        while (p != null && p.next != null) {
            pre.next = p.next;
            pre = p;
            p = p.next.next;
            pre.next.next = pre;
            pre = pre.next;
        }
        if (p != null)
            pre.next = p;
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode virtual = new ListNode(0);
        virtual.next = head;
        ListNode p = head;
        ListNode pre = virtual;
        while (p != null && p.next != null) {
            pre.next = p.next;
            pre = p;
            p = p.next.next;
            pre.next.next = pre;
        }
        pre.next = p;
        return virtual.next;
    }
}