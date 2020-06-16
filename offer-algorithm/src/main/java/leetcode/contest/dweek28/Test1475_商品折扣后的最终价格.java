package leetcode.contest.dweek28;

import java.util.Arrays;

public class Test1475_商品折扣后的最终价格 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(new Solution().finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(new Solution().finalPrices(new int[]{10, 1, 1, 6})));
    }

    static class Solution {
        public int[] finalPrices(int[] prices) {
            if (prices == null) {
                return null;
            }
            int[] res = new int[prices.length];
            for (int i = 0; i < prices.length; i++) {
                int min = 0;
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] <= prices[i]) {
                        min = prices[j];
                        break;
                    }
                }
                res[i] = prices[i] - min;
            }
            return res;
        }
    }

}
