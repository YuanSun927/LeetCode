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

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) { // 当前节点无左子树
                list.add(cur.val);  // 访问该节点
                cur = cur.right;    // 沿线索返回
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur; // 建立线索
                    cur = cur.left;
                } else { // prev.right == cur 当前节点的左子树访问完毕
                    list.add(cur.val);
                    cur = cur.right;
                    prev.right = null;
                }
            }
        }
        return list;
    }
}