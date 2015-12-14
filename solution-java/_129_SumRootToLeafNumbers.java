/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/
public class _129_SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int number, int sum) {
        if (node == null)
            return sum;         
        number = number * 10 + node.val;
        if (node.left == null && node.right == null)
            return sum += number;
        return sum(node.left, number, sum) + sum(node.right, number, sum);
    }

    private int sum(TreeNode node, int number) {
        if (node == null)
            return 0;         
        number = number * 10 + node.val;
        if (node.left == null && node.right == null)
            return number;
        return sum(node.left, number) + sum(node.right, number);
    }
}