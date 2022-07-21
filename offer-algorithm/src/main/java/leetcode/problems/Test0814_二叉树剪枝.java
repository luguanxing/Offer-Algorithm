package leetcode.problems;

public class Test0814_二叉树剪枝 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                null,
                new TreeNode(
                        0,
                        new TreeNode(0),
                        new TreeNode(1)
                )
        );
        root = new Solution().pruneTree(root);
        System.out.println(root);
    }

    static class Solution {
        public TreeNode pruneTree(TreeNode root) {
            return checkAndRemove(root);
        }

        private TreeNode checkAndRemove(TreeNode root) {
            if (root == null) {
                return null;
            }
            root.left = checkAndRemove(root.left);
            root.right = checkAndRemove(root.right);
            if (root.left == null && root.right == null && root.val == 0) {
                return null;
            } else {
                return root;
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
