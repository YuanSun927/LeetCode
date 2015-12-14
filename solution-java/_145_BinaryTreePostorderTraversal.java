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
}