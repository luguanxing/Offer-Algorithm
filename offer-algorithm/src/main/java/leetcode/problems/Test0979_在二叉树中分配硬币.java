package leetcode.problems;

public class Test0979_在二叉树中分配硬币 {

    public static void main(String[] args) {

    }

    static class Solution {
        int res = 0;

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return res;
        }

        private int[] dfs(TreeNode root) {
            // 返回金币数量和节点数量
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int coins = left[0] + right[0] + root.val;
            int nodes = left[1] + right[1] + 1;
            // 金币和数量的差为该子树需要调入或调出的数目
            int diff = Math.abs(coins - nodes);
            res += diff;
            return new int[]{coins, nodes};
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
