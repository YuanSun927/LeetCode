/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/
public class _234_PalindromeLinkedList {
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode nextNode = head.next, fast = head.next;
        ListNode firstHead = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = nextNode.next;
            nextNode.next = firstHead;
            firstHead = nextNode;
            nextNode = temp;
        }
        if (fast == null) {
            firstHead = firstHead.next;
        }
        while (nextNode != null) {
            if (firstHead.val != nextNode.val)
                return false;
            firstHead = firstHead.next;
            nextNode = nextNode.next;
        }
        return true;
    } 
}