package leetcode.problems;

public class Test0714_买卖股票的最佳时机含手续费 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(
                new int[]{1, 3, 2, 8, 4, 9}, 2
        ));
        System.out.println(new Solution().maxProfit(
                new int[]{1, 3, 7, 5, 10, 3}, 3
        ));
        System.out.println();
        System.out.println(new Solution2().maxProfit(
                new int[]{1, 3, 2, 8, 4, 9}, 2
        ));
        System.out.println(new Solution2().maxProfit(
                new int[]{1, 3, 7, 5, 10, 3}, 3
        ));
    }

    static class Solution2 {
        public int maxProfit(int[] prices, int fee) {
            int len = prices.length;
            int[] empty = new int[len];
            int[] position = new int[len];
            position[0] = -prices[0] - fee;
            for (int i = 1; i < len; i++) {
                empty[i] = Math.max(empty[i - 1], position[i - 1] + prices[i]);
                position[i] = Math.max(position[i - 1], empty[i - 1] - prices[i] - fee);
            }
            return empty[len - 1];
        }
    }

    static class Solution {
        public int maxProfit(int[] prices, int fee) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }
    }

}
