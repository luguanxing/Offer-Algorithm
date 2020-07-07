package leetcode.problems;

public class Test0112_路径总和 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        System.out.println(new Solution().hasPathSum(root, 3));
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
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            return checkNode(root, 0, sum);
        }

        private boolean checkNode(TreeNode root, int curSum, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return curSum + root.val == sum;
            }
            return checkNode(root.left, curSum + root.val, sum) || checkNode(root.right, curSum + root.val, sum);
        }
    }

}
