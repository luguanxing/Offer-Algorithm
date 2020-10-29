package leetcode.problems;

public class Test0124_二叉树中的最大路径和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxPathSum(
                new TreeNode(
                        -10,
                        new TreeNode(9),
                        new TreeNode(
                                20,
                                new TreeNode(15),
                                new TreeNode(7)
                        )
                )
        ));
        System.out.println(new Solution().maxPathSum(
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(3)
                )
        ));
        System.out.println(new Solution().maxPathSum(
                new TreeNode(
                        9,
                        new TreeNode(6),
                        new TreeNode(
                                -3,
                                new TreeNode(-6),
                                new TreeNode(2,
                                        new TreeNode(
                                                2,
                                                new TreeNode(-6, new TreeNode(-6), null),
                                                new TreeNode(-6)
                                        ),
                                        null)
                        )
                )
        ));
    }

    static class Solution {
        private int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 后序遍历同时，计算该点单边的最大值
            getSideMax(root);
            return max;
        }

        private int getSideMax(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftSideMax = getSideMax(root.left);
            int rightSideMax = getSideMax(root.right);
            // 左右边最大值之和加上当前节点（可能不需要左右边）
            int maxSum = Math.max(0, leftSideMax) + Math.max(0, rightSideMax) + root.val;
            max = Math.max(max, maxSum);
            // 返回左右边最大值加上当前节点（可能不需要左右边）
            return Math.max(0, Math.max(leftSideMax, rightSideMax)) + root.val;
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
