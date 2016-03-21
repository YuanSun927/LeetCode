/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
*/
public class _99_RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode[] errNodes = new TreeNode[2];
        TreeNode p = root;
        TreeNode prev = null;
        int times = 0;
        // Inorder traverse
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (prev != null && p.val < prev.val) {
                if (errNodes[0] == null)
                    errNodes[0] = prev;
                errNodes[1] = p;
                times++;
            }
            if (times == 2) // Two error nodes have been found
                break;
            prev = p;
            p = p.right;
        }
        if (errNodes[0] != null && errNodes[1] != null) {
            // Swap two nodes' value
            int temp = errNodes[0].val;
            errNodes[0].val = errNodes[1].val;
            errNodes[1].val = temp;
        }
    }

    // Morris traverse
    // 一遍关于Morrise遍历的博客 http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.htm
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode[] errNodes = new TreeNode[2];
        while (cur != null) {
            if (cur.left == null) {
                detect(cur, prev, errNodes);
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur) {
                    node = node.right;
                }
                if (node.right == null) {
                    node.right = cur;
                    cur = cur.left;
                } else {
                    detect(cur, prev, errNodes);
                    node.right = null;
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        if (errNodes[0] != null && errNodes[1] != null) {
            // Swap two nodes' value
            int temp = errNodes[0].val;
            errNodes[0].val = errNodes[1].val;
            errNodes[1].val = temp;
        }
    }

    private void detect(TreeNode cur, TreeNode prev, TreeNode[] errNodes) {
        if (prev != null && cur.val < prev.val) {
            if (errNodes[0] == null) {
                errNodes[0] = prev;
            }
            errNodes[1] = cur;
        }
    }
}