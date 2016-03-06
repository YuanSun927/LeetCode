/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
public class _113_PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        ArrayList<Integer> path = new ArrayList<>();
        path(root, sum, path, result);
        return result;
    }

    private void path(TreeNode root, int sum, ArrayList<Integer> path, List<List<Integer>> result) {
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ArrayList<Integer> newPath = new ArrayList<>(path);
            result.add(newPath);
        }
        if (root.left != null)
            path(root.left, sum, path, result);
        if (root.right != null)
            path(root.right, sum, path, result);
        path.remove(path.size() - 1);
    }
}