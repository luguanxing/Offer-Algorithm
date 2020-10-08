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

}
