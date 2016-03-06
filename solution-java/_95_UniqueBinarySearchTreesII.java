/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
public class _95_UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }

    // 以下两个方法思路是一样的，第一个方法判断分支详细，LeetCode测试时间更快一些
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start == end) {
            trees.add(new TreeNode(start));
            return trees;
        }
        for (int i = start; i <= end; i++) {
            if (i == start) {
                List<TreeNode> subTrees = generateTrees(start + 1, end);
                for (TreeNode t : subTrees) {
                    TreeNode parent = new TreeNode(start);
                    parent.right = t;
                    trees.add(parent);
                }
            } else if (i == end) {
                List<TreeNode> subTrees = generateTrees(start, end - 1);
                for (TreeNode t : subTrees) {
                    TreeNode parent = new TreeNode(end);
                    parent.left = t;
                    trees.add(parent);
                }
            } else {
                List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
                List<TreeNode> rightSubTrees = generateTrees(i + 1, end);
                for (TreeNode lt : leftSubTrees) {
                    for (TreeNode rt : rightSubTrees) {
                        TreeNode parent = new TreeNode(i);
                        parent.left = lt;
                        parent.right = rt;
                        trees.add(parent);
                    }
                }
            }
        }
        return trees;
    }

    // 基于上个方法改进，减少了判断分支，测试运行时间慢一些
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
                List<TreeNode> rightSubTrees = generateTrees(i + 1, end);
                for (TreeNode lt : leftSubTrees) {
                    for (TreeNode rt : rightSubTrees) {
                        TreeNode parent = new TreeNode(i);
                        parent.left = lt;
                        parent.right = rt;
                        trees.add(parent);
                    }
                }
            }
        }
        return trees;
    }
}