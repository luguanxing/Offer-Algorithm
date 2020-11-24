package leetcode.problems;

public class Test0222_完全二叉树的节点个数 {

    public static void main(String[] args) {

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
        int count = 0;

        public int countNodes(TreeNode root) {
            preOrder(root);
            return count;
        }

        private void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            count++;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

}
