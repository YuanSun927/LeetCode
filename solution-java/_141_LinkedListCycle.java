/*
*/
public class _141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode p = head.next;
        ListNode q = head.next.next;
        while (p != q && p != null && q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p == q; 
    }
}