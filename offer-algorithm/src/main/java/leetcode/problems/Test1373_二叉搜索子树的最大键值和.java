package leetcode.problems;

public class Test1373_二叉搜索子树的最大键值和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumBST(
                new TreeNode(
                        1,
                        new TreeNode(
                                4,
                                new TreeNode(2),
                                new TreeNode(4)
                        ),
                        new TreeNode(
                                3,
                                new TreeNode(2),
                                new TreeNode(
                                        5,
                                        new TreeNode(4),
                                        new TreeNode(6)
                                )
                        )
                )
        ));
        System.out.println(new Solution().maxSumBST(
                new TreeNode(
                        4,
                        new TreeNode(
                                3,
                                new TreeNode(1),
                                new TreeNode(2)
                        ),
                        null
                )
        ));
    }

    static class Solution {
        int max = 0;

        public int maxSumBST(TreeNode root) {
            dfs(root);
            return max;
        }

        public int[] dfs(TreeNode root) {
            if (root == null) {
                return null;
            }
            int[] l = dfs(root.left);
            int[] r = dfs(root.right);
            boolean leftIsBST = (l == null || l[0] == 1);
            Integer leftMax = l == null ? null : l[1];
            Integer leftMin = l == null ? null : l[2];
            Integer leftSum = l == null ? null : l[3];
            boolean rightIsBST = (r == null || r[0] == 1);
            Integer rightMax = r == null ? null : r[1];
            Integer rightMin = r == null ? null : r[2];
            Integer rightSum = r == null ? null : r[3];
            if (!leftIsBST || !rightIsBST) {
                return new int[]{0, 0, 0, 0};
            }
            if ((leftMax != null && leftMax >= root.val) || (rightMin != null && rightMin <= root.val)) {
                return new int[]{0, 0, 0, 0};
            }
            int sum = (leftSum == null ? 0 : leftSum)
                    + (rightSum == null ? 0 : rightSum)
                    + root.val;
            max = Math.max(max, sum);
            return new int[]{1, Math.max(root.val, rightMax == null ? Integer.MIN_VALUE : rightMax), Math.min(root.val, leftMin == null ? Integer.MAX_VALUE : leftMin), sum};
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
