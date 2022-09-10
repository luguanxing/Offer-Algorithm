package leetcode.problems;

public class Test0669_修剪二叉搜索树 {

    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            TreeNode leftNode = trimBST(root.left, low, high);
            TreeNode rightNode = trimBST(root.right, low, high);
            if (low <= root.val && root.val <= high) {
                root.left = leftNode;
                root.right = rightNode;
                return root;
            } else if (root.val < low) {
                // remove root & root.left
                return rightNode;
            } else {
                // remove root & root.right
                return leftNode;
            }
        }
    }

    public class TreeNode {
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
