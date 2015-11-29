/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/
public class _107_BinaryTreeLevelOrderTraversalII {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
     	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
     	if (root == null)
     		return result;
     	Queue<TreeNode> queue = new ArrayDeque<>();
     	queue.add(root);
     	while (!queue.isEmpty()) {
     		LinkedList<Integer> list = new LinkedList<>();
     		int levelSize = queue.size();
     		for (int i = 0; i < levelSize; i++) {
     			TreeNode t = queue.remove();
     			list.add(t.val);
     			if (t.left != null)
     				queue.add(t.left);
     			if (t.right != null)
     				queue.add(t.right);
     		}
     		result.addFirst(list);
     	}
     	return result;
    }

}