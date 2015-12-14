/*
Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, or transmitted across a network connection 
link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree.
There is no restriction on how your serialization/deserialization algorithm should work.
You just need to ensure that a binary tree can be serialized to a string and this string
can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states.
Your serialize and deserialize algorithms should be stateless.
*/
public class _297_SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuffer treeStr = new StringBuffer("");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        treeStr.append(root.val);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode n = queue.remove();
                if (n.left != null) {
                    treeStr.append("," + n.left.val);
                    queue.add(n.left);
                } else {
                    treeStr.append(",null");
                }
                if (n.right != null) {
                    treeStr.append("," + n.right.val);
                    queue.add(n.right);
                } else {
                    treeStr.append(",null");
                }
            }
        }
        return treeStr.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.trim().equals(""))
            return null;
        String[] nodes = data.trim().split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode n = queue.remove();
            String left = nodes[i++];
            String right = nodes[i++];
            if (!left.equals("null")) {
                n.left = new TreeNode(Integer.valueOf(left));
                queue.add(n.left);
            }
            if (!right.equals("null")) {
                n.right = new TreeNode(Integer.valueOf(right));
                queue.add(n.right);
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));