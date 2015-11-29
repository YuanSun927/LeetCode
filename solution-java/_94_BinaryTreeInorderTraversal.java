/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/
public class _94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode p = root;
        while (!stack.isEmpty()) {
            while (p.left != null) {
                stack.push(p.left);
                p = p.left;
            }
            TreeNode t;
            do {
                t = stack.pop();
                list.add(t.val);
            } while (!stack.isEmpty() && t.right == null);
            if (t.right != null) {
                stack.push(t.right);
                p = t.right;
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            list.add(p.val);
            p = p.right;
        }
        return list;
    }
}