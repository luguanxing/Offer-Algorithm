package leetcode.problems;

import java.util.Arrays;

public class Test2944_购买水果需要的最少金币数 {

    public static void main(String[] args) {
        // prices = [3,1,2]
        System.out.println(new Solution().minimumCoins(new int[]{3, 1, 2}));
        // prices = [1,10,1,1]
        System.out.println(new Solution().minimumCoins(new int[]{1, 10, 1, 1}));
        // prices = [26,18,6,12,49,7,45,45]
        System.out.println(new Solution().minimumCoins(new int[]{26, 18, 6, 12, 49, 7, 45, 45}));
    }

    static class Solution {
        public int minimumCoins(int[] prices) {
            int len = prices.length;
            // dp[i] 表示购买到第i个水果需要的最少金币数
            int[] dp = new int[len + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            // 计算dp[i]时选择要或不要这个水果，同时可以按要水果的代价更新dp[i+1]到dp[2*i]
            dp[0] = 0;
            for (int i = 1; i <= len; i++) {
                int price = prices[i-1];
                dp[i] = Math.min(dp[i], dp[i-1] + price);
                for (int j = i + 1; j <= Math.min(len, 2 * i); j++) {
                    dp[j] = Math.min(dp[j], dp[i-1] + price);
                }
            }
            return dp[len];
        }
    }

}
