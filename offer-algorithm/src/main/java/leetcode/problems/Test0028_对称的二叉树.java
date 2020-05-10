package leetcode.problems;

public class Test0028_对称的二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        System.out.println(new Solution().isSymmetric(root));
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        boolean isSymmetric(TreeNode left, TreeNode right) {
            if ((left == null && right != null) || (left != null && right == null)) {
                return false;
            } else if (left == null && right == null) {
                return true;
            } else {
                if (left.val == right.val) {
                    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
                } else {
                    return false;
                }
            }
        }
    }

}
