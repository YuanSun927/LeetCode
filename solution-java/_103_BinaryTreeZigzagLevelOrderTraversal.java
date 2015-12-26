/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
public class _103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null)
            return list;
        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        int level = 1;
        oddStack.push(root);
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            int levelSize = level % 2 == 1 ? oddStack.size() : evenStack.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                if (level % 2 == 1) {
                    TreeNode node = oddStack.pop();
                    levelList.add(node);
                    if (node.left != null)
                        evenStack.push(node.left);
                    if (node.right != null)
                        oddStack.push(node.right);
                } else {
                    TreeNode node = evenStack.pop();
                    levelList.add(node);
                    if (node.right != null)
                        oddStack.push(node.right);
                    if (node.left != null)
                        evenStack.push(node.left);
                }
            }
            list.add(levelList);
            level++;
        }
    }
}