/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/
public class _117_PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeLinkNode p = null;
            for (int i = 0; i < levelSize; i++) {
                TreeLinkNode q = queue.remove();
                if (q.left != null)
                    queue.add(q.left);
                if (q.right != null)
                    queue.add(q.right);
                if (i > 0)
                    p.next = q;
                p = q;   
            }
            p.next = null;
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}