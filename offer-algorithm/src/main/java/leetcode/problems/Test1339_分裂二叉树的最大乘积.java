package leetcode.problems;

public class Test1339_分裂二叉树的最大乘积 {

    public static void main(String[] args) {

    }

    static class Solution {
        long totalSum = 0;
        long maxProduct = 0;

        public int maxProduct(TreeNode root) {
            dfsGetTotalSum(root);
            dfsGetMaxProduct(root);
            return (int) (maxProduct % 1_000_000_007);
        }

        private void dfsGetTotalSum(TreeNode root) {
            if (root == null) {
                return;
            }
            totalSum += root.val;
            dfsGetTotalSum(root.left);
            dfsGetTotalSum(root.right);
        }

        private int dfsGetMaxProduct(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftSum = dfsGetMaxProduct(root.left);
            int rightSum = dfsGetMaxProduct(root.right);
            maxProduct = Math.max(maxProduct, (totalSum - leftSum) * leftSum);
            maxProduct = Math.max(maxProduct, (totalSum - rightSum) * rightSum);
            return (root.val + leftSum + rightSum);
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
