package leetcode.problems;

public class Test0104_二叉树的最大深度 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(new Solution().maxDepth(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            return proOrderCheck(root, 0);
        }

        private int proOrderCheck(TreeNode root, int level) {
            if (root == null) {
                return level;
            }
            return Math.max(proOrderCheck(root.left, level + 1), proOrderCheck(root.right, level + 1));
        }
    }

}
