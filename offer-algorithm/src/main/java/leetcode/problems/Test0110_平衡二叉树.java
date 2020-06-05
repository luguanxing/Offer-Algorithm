package leetcode.problems;

public class Test0110_平衡二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(3);
        root.left = left;
        left.left = leftLeft;
        System.out.println(new Solution().isBalanced(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 当前节点左右差不超过1并且左右子树均为平衡树
            return (Math.abs(getHeight(root.left, 0) - getHeight(root.right, 0)) <= 1) && (isBalanced(root.left)) && (isBalanced(root.right));
        }

        private int getHeight(TreeNode root, int height) {
            if (root == null) {
                return height;
            }
            return Math.max(getHeight(root.left, height + 1), getHeight(root.right, height + 1));
        }
    }

}
