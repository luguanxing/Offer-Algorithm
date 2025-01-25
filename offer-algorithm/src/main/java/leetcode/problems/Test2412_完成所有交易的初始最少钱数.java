package leetcode.problems;

public class Test2412_完成所有交易的初始最少钱数 {

    public static void main(String[] args) {
        // transactions = [[2,1],[5,0],[4,2]]
        System.out.println(new Solution().minimumMoney(new int[][]{{2, 1}, {5, 0}, {4, 2}}));
        // transactions = [[3,0],[0,3]]
        System.out.println(new Solution().minimumMoney(new int[][]{{3, 0}, {0, 3}}));
        // [[7,2],[0,10],[5,0],[4,1],[5,8],[5,9]]
        System.out.println(new Solution().minimumMoney(new int[][]{{7, 2}, {0, 10}, {5, 0}, {4, 1}, {5, 8}, {5, 9}}));
    }

    static class Solution {
        public long minimumMoney(int[][] transactions) {
            int len = transactions.length;
            // cost[i][0] 表示第i个交易最多要扣多少钱
            // cost[i][1] 表示第i个交易的收入
            int[][] costs = new int[len][2];
            for (int i = 0; i < len; i++) {
                costs[i][0] = -transactions[i][0];
                costs[i][1] = transactions[i][1] - transactions[i][0];
            }
            // 计算之前其它交易全亏 同时 遇到最多扣钱的情况下 的最大值
            long res = Long.MAX_VALUE;
            long maxNegativeSum = 0;
            for (int[] cost : costs) {
                maxNegativeSum += Math.min(cost[1], 0);
            }
            for (int[] cost : costs) {
                // 计算出扣除当前收入后，再加上最多扣钱的情况下的最大值
                long current = maxNegativeSum - Math.min(cost[1], 0) + cost[0];
                res = Math.min(res, current);
            }
            return res * -1;
        }
    }

}
