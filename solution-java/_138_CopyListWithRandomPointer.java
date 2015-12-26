/*
A linked list is given such that each node contains an additional random pointer
which could point to any node in the list or null.

Return a deep copy of the list.
*/
public class _138_CopyListWithRandomPointer {

    public RandomListNode copyRandomList1(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode tail = dummy;
        for (RandomListNode p = head; p != null; p = p.next) {
            RandomListNode node = new RandomListNode(p.label);
            tail.next = node;
            map.put(p, node);
        }
        for (RandomListNode p = head; p != null; p = p.next) {
            if (p.random != null) {
                map.get(p).random = map.get(p.random);
            }
        }
        return dummy.next;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        for (RandomListNode p = head; p != null;) {
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        for (RandomListNode p = head; p != null;) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode tail = dummy;
        for (RandomListNode p = head; p != null;) {
            tail.next = p.next;
            tail = p.next;
            p.next = p.next.next;
            p = p.next;
        }
        return dummy.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
}
