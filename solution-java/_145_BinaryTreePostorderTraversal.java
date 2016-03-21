/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/
public class _145_BinaryTreePostorderTraversal {
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode lastPop = root;
        stack.push(p);
        while (!stack.isEmpty()) {
            TreeNode left = stack.peek().left;
            TreeNode right = stack.peek().right;
            if (left != null && left != lastPop && right != lastPop) {
                stack.push(left);
            } else if (right != null && right != lastPop) {
                stack.push(right);
            } else {
                lastPop = stack.pop();
                result.add(lastPop.val);
            }
        }
        return result;
    }

    // Morris traverse
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    traverseRightEdge(cur.left, result);
                    cur = cur.right;
                }
            }
        }
        traverseRightEdge(root, result);
        return result;
    }

    private void traverseRightEdge(TreeNode node, List<Integer> result) {
        TreeNode tail = reverse(node);
        TreeNode cur = tail;
        while (cur != null) {
            result.add(cur.val);
            cur = cur.right;
        }
        reverse(tail);
    }

    private TreeNode reverse(TreeNode node) {
        TreeNode head = null;
        while (node != null) {
            TreeNode temp = node;
            node = node.right;
            temp.right = head;
            head = temp;
        }
        return head;
    }
}