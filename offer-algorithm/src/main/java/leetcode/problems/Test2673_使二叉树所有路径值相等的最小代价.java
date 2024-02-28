package leetcode.problems;

public class Test2673_使二叉树所有路径值相等的最小代价 {

    public static void main(String[] args) {
        System.out.println(new Solution().minIncrements(7, new int[]{1, 5, 2, 2, 3, 3, 1}));
        System.out.println(new Solution().minIncrements(3, new int[]{5, 3, 3}));
        System.out.println(new Solution().minIncrements(15, new int[]{764, 1460, 2664, 764, 2725, 4556, 5305, 8829, 5064, 5929, 7660, 6321, 4830, 7055, 3761}));
    }

    static class Solution {
        int res = 0;

        public int minIncrements(int n, int[] cost) {
            getPathValue(cost, 1);
            return res;
        }

        private int getPathValue(int[] cost, int index) {
            if (index > cost.length) {
                return 0;
            }
            // 当前节点需要补充的数字，是由左右子树的路径值决定的，而不是由左右子树的和
            int leftValue = getPathValue(cost, index * 2);
            int rightValue = getPathValue(cost, index * 2 + 1);
            res += Math.abs(leftValue - rightValue);
            // 当前节点路径值 = 当前节点值 + 左右路径值中的最较大值
            return cost[index - 1] + Math.max(leftValue, rightValue);
        }
    }

}
