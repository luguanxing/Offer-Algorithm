package leetcode.problems;

public class Test0188_买卖股票的最佳时机IV {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(new Solution().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(new Solution().maxProfit(2, new int[]{}));
    }

    static class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            // position[i][k]表示第i天用了k次买入机会时的持仓现金, clear[i][k]表示第i天清仓用了k次买入机会时的现金
            // clear[i][k]表示第i天用了k次卖出机会时的清仓现金
            int[][] position = new int[prices.length][k + 1];
            int[][] clear = new int[prices.length][k + 1];
            for (int i = 0; i <= k; i++) {
                // 第0天持仓表示负债买入
                position[0][i] = -prices[0];
            }
            for (int i = 1; i < prices.length; i++) {
                for (int j = 1; j <= k; j++) {
                    // 今天持仓=昨天持仓或今天买入，今天清仓=昨天清仓货今天卖出
                    position[i][j] = Math.max(position[i - 1][j], clear[i - 1][j - 1] - prices[i]);
                    clear[i][j] = Math.max(clear[i - 1][j], position[i - 1][j] + prices[i]);
                }
            }
            return clear[prices.length - 1][k];
        }
    }

}
