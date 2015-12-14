/*
Sort a linked list in O(n log n) time using constant space complexity.
*/
public class _148_SortList {
    
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        ListNode pivot = head;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val < pivot.val) {
                ListNode temp = p.next;
                p.next = p.next.next;
                temp.next = head;
                head = temp;
            }
            p = p.next;
        }
        ListNode newHead = pivot.next;
        pivot.next = null;
        sortList(head); 
        sortList(newHead);
        pivot.next = newHead;
        return head;
    }
}