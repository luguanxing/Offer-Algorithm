package leetcode.contest.week292;

public class Test6057_统计值等于子树平均值的节点数 {

    public static void main(String[] args) {
        System.out.println(new Solution().averageOfSubtree(new TreeNode(4,
                new TreeNode(
                        8,
                        new TreeNode(0),
                        new TreeNode(1)
                ),
                new TreeNode(
                        5,
                        null,
                        new TreeNode(6)
                )
        )));
        System.out.println(new Solution().averageOfSubtree(new TreeNode(1)));
    }

    static class Solution {
        int res = 0;

        public int averageOfSubtree(TreeNode root) {
            // 后序遍历
            postOrder(root);
            return res;
        }

        private int[] postOrder(TreeNode root) {
            if (root == null) {
                return null;
            }
            int[] leftInfos = postOrder(root.left);
            int[] rightInfos = postOrder(root.right);
            int currentSum = (leftInfos == null ? 0 : leftInfos[0]) + (rightInfos == null ? 0 : rightInfos[0]) + root.val;
            int currentCnt = (leftInfos == null ? 0 : leftInfos[1]) + (rightInfos == null ? 0 : rightInfos[1]) + 1;
            if (currentCnt > 0 && currentSum / currentCnt == root.val) {
                res++;
            }
            return new int[]{currentSum, currentCnt};
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
