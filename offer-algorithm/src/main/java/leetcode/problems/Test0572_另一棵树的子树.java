package leetcode.problems;

public class Test0572_另一棵树的子树 {

    public static void main(String[] args) {
        System.out.println(new Solution().isSubtree(
                new TreeNode(1, new TreeNode(1), null),
                new TreeNode(1)
        ));
    }

    static class Solution {
        boolean result = false;

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            // 需要同时DFS遍历点和比较Tree，不能写在一个方法里
            dfsAllNodes(root, subRoot);
            return result;
        }

        private void dfsAllNodes(TreeNode root, TreeNode subRoot) {
            // 终止和剪枝条件
            if (root == null || result) {
                return;
            }
            // 逐个比较
            result |= compareTwoTrees(root, subRoot);
            dfsAllNodes(root.left, subRoot);
            dfsAllNodes(root.right, subRoot);
        }

        private boolean compareTwoTrees(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) {
                return true;
            } else if (root == null || subRoot == null) {
                return false;
            } else if (root.val == subRoot.val) {
                return compareTwoTrees(root.left, subRoot.left) && compareTwoTrees(root.right, subRoot.right);
            } else {
                return false;
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
