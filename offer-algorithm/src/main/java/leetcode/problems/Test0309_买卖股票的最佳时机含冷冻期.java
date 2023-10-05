package leetcode.problems;

public class Test0309_买卖股票的最佳时机含冷冻期 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(new Solution().maxProfit(new int[]{1}));
        System.out.println(new Solution().maxProfit(new int[]{2, 1, 4}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len == 1) {
                return 0;
            }
            if (len == 2) {
                return Math.max(0, prices[1] - prices[0]);
            }
            int[] postition = new int[len];
            int[] empty = new int[len];
            postition[0] = -prices[0];
            postition[1] = Math.max(-prices[0], -prices[1]);
            empty[0] = 0;
            empty[1] = Math.max(0, prices[1] - prices[0]);
            for (int i = 2; i < len; i++) {
                postition[i] = Math.max(postition[i - 1], empty[i - 2] - prices[i]);
                empty[i] = Math.max(empty[i - 1], postition[i - 1] + prices[i]);
            }
            return empty[len - 1];
        }
    }

}
