package leetcode;

public class Test121_买卖股票的最佳时机 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int min = prices[0];
            int maxProfile = 0;
            for (int i = 1; i < prices.length; i++) {
                int price = prices[i];
                maxProfile = Math.max(maxProfile, price - min);
                min = Math.min(min, price);
            }
            return maxProfile;
        }
    }

}
