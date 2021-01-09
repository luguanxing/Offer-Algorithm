package leetcode.problems;

public class Test0123_买卖股票的最佳时机III {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            // 第i天用一次机会没持仓的最大总现金
            int dp_i10 = 0;
            // 第i天用一次机会有持仓的最大总现金
            int dp_i11 = Integer.MIN_VALUE;
            // 第i天用两次机会没持仓的最大总现金
            int dp_i20 = 0;
            // 第i天用两次机会有持仓的最大总现金
            int dp_i21 = Integer.MIN_VALUE;
            for (int price : prices) {
                dp_i20 = Math.max(dp_i20, dp_i21 + price); // 昨日未持仓，或者昨日持仓并卖掉
                dp_i21 = Math.max(dp_i21, dp_i10 - price); // 昨日已持仓，或昨日未持仓但买入
                dp_i10 = Math.max(dp_i10, dp_i11 + price); // 昨日未持仓，或者昨日持仓并卖掉
                dp_i11 = Math.max(dp_i11, -price);         // 昨日已持仓，或昨日刚买入
            }
            return dp_i20;
        }
    }

    static class Solution_DP {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            // position[i][k]表示第i天使用了k次机会持仓的现金
            // clear[i][k]表示第i天使用了k次机会清仓的现金
            int[][] position = new int[len][3];
            int[][] clear = new int[len][3];
            position[0][0] = -prices[0];
            position[0][1] = -prices[0];
            position[0][2] = -prices[0];
            clear[0][0] = 0;
            clear[0][1] = 0;
            clear[0][2] = 0;
            for (int i = 1; i < len; i++) {
                // 当天不操作，或者当天操作了（买入/卖出)
                position[i][1] = Math.max(position[i-1][1], clear[i-1][0] - prices[i]);
                position[i][2] = Math.max(position[i-1][2], clear[i-1][1] - prices[i]);
                clear[i][1] = Math.max(clear[i-1][1], position[i-1][1] + prices[i]);
                clear[i][2] = Math.max(clear[i-1][2], position[i-1][2] + prices[i]);
            }
            return clear[len-1][2];
        }
    }

}
