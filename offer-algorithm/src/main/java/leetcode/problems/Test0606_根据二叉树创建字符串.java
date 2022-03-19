package leetcode.problems;

public class Test0606_根据二叉树创建字符串 {

    public static void main(String[] args) {

    }

    static class Solution {
        public String tree2str(TreeNode root) {
            String res = dfs(root);
            return res;
        }

        private String dfs(TreeNode root) {
            // 面向分支编程
            if (root == null) {
                return "";
            }
            if (root.left == null && root.right == null) {
                return root.val + "";
            }
            if (root.left == null && root.right != null) {
                return root.val + "()(" + dfs(root.right) + ")";
            }
            if (root.left != null && root.right == null) {
                return root.val + "(" + dfs(root.left) + ")";
            }
            return root.val + "(" + dfs(root.left) + ")" + "(" + dfs(root.right) + ")";
        }
    }

    static public class TreeNode {
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
