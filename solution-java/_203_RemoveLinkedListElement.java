/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/
public class _203_RemoveLinkedListElement {

    public ListNode removeElements(ListNode head, int val) {
        ListNode pPre = head;
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val == val) {
                if (p == head) {
                    head = p.next;
                } else {
                    pPre.next = p.next;
                }
            } else {
                pPre = p;
            }
        }
        return head;
    }
}