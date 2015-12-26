/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/
public class _257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new LinkedList<>();
        if (root != null)
            return pathList;
        traverse(root, "", pathList);
        return pathList;
    }

    private void traverse(TreeNode root, String path, List<String> pathList) {
        path += "".equals(path) ? root.val : "->" + root.val;
        if (root.left == null && root.right == null) {
            pathList.add(path);
        }
        if (root.left != null)
            traverse(root.left, path, pathList);
        if (root.right != null)
            traverse(root.right, path, pathList);
    }}