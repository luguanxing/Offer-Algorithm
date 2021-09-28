package leetcode.problems;

public class Test0437_路径总和III {

    public static void main(String[] args) {

    }

    static class Solution {
        int res = 0;

        public int pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum);
            return res;
        }

        private void dfs(TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }
            dfs(root.left, targetSum);
            check(root, targetSum);
            dfs(root.right, targetSum);
        }

        private void check(TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }
            if (root.val == targetSum) {
                // 匹配后也继续需要向后搜索
                res++;
            }
            check(root.left, targetSum - root.val);
            check(root.right, targetSum - root.val);
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
