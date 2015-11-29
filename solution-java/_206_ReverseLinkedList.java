/**
 * Reverse a singly linked list.
 */
public class _206_ReverseLinkedList {

    public ListNode reverseList1(ListNode head) {
        ListNode oldHead = head;
        while (oldHead != null && oldHead.next != null) {
        	ListNode temp = oldHead.next;
        	oldHead.next = oldHead.next.next;
        	temp.next = head;
        	head = temp;
		}
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = last;
            last = head;
            head = temp;
        }
        return last;
    }
    
    public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}