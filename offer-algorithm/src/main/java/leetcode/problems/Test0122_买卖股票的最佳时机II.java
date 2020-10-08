package leetcode.problems;

public class Test0122_买卖股票的最佳时机II {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new Solution().maxProfit(new int[]{2, 4, 1}));
        System.out.println(new Solution().maxProfit(new int[]{2, 1, 2, 0, 1}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int last = prices[0];
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                int price = prices[i];
                if (price > last) {
                    // 当天已经盈利，则出货
                    sum += price - last;
                }
                // 继续找更低的买点
                last = price;
            }
            return sum;
        }
    }

    static class Solution_择时 {
        public int maxProfit(int[] prices) {
            int buy = -1;
            int sell = -1;
            int sum = 0;
            for (int price : prices) {
                if (buy == -1 || (sell == -1 && price < buy)) {
                    // 未初始化买点或有更好的买点选择更好的买点
                    buy = price;
                    continue;
                }
                if (sell == -1 || sell < price) {
                    // 未初始化卖点或有更好的卖点选择更好的卖点
                    sell = price;
                    continue;
                }
                // 没有更好的卖点了则出货
                sum += sell - buy;
                buy = price;
                sell = -1;
            }
            if (sell - buy > 0) {
                sum += sell - buy;
            }
            return sum;
        }
    }

}
