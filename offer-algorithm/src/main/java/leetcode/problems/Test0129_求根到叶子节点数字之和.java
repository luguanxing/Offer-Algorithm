package leetcode.problems;

public class Test0129_求根到叶子节点数字之和 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(new Solution().sumNumbers(root));
    }

    static class Solution {
        private int sum;

        public int sumNumbers(TreeNode root) {
            sum = 0;
            preOrder(root, sum);
            return sum;
        }

        private void preOrder(TreeNode root, int currentSum) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                sum += currentSum * 10 + root.val;
            }
            preOrder(root.left, currentSum * 10 + root.val);
            preOrder(root.right, currentSum * 10 + root.val);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
