package leetcode.problems;

public class Test3573_买卖股票的最佳时机V {

    public static void main(String[] args) {
        // prices = [1,7,9,8,2], k = 2
        System.out.println(new Solution().maximumProfit(new int[]{1, 7, 9, 8, 2}, 2));
        // prices = [12,16,19,19,8,1,19,13,9], k = 3
        System.out.println(new Solution().maximumProfit(new int[]{12, 16, 19, 19, 8, 1, 19, 13, 9}, 3));
    }

    static class Solution {
        public long maximumProfit(int[] prices, int k) {
            int n = prices.length;
            // dp[i][j]表示前i天，进行了j次交易所能获得的最大利润
            // dp[i][j] = max(dp[i-1][j], dp[t][k-1] + abs(prices[i-1] - prices[t])) 0<=t<i
            // 优化，拆分abs(prices[i-1] - prices[t]))
            // dp[i][j] = max(
            //      dp[i-1][j],
            //      max(dp[t][j-1] - prices[t]) + prices[i-1], max(dp[t][j-1] + prices[t]) - prices[i-1])
            // )
            long[][] dp = new long[n + 1][k + 1];
            for (int j = 1; j <= k; j++) {
                // best 是“针对固定 j 的前缀最值”，必须在遍历 i 时更新；不能在遍历 j 时更新。
                // 所以循环顺序必须是 j 外 i 内
                // bestMinus = max (dp[lastI][j-1] - prices[lastI])，需要在每次 i 循环时更新
                // bestPlus  = max (dp[lastI][j-1] + prices[lastI])，需要在每次 i 循环时更新
                long bestMinus = Long.MIN_VALUE / 4;
                long bestPlus = Long.MIN_VALUE / 4;
                for (int i = 1; i <= n; i++) {
                    // 更新 bestMinus 和 bestPlus
                    bestMinus = Math.max(bestMinus, dp[i - 1][j - 1] - prices[i - 1]);
                    bestPlus = Math.max(bestPlus, dp[i - 1][j - 1] + prices[i - 1]);
                    // 计算 dp[i][j]
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            Math.max(bestMinus + prices[i - 1], bestPlus - prices[i - 1])
                    );
                }
            }
            return dp[n][k];
        }
    }

    static class Solution_超时 {
        public long maximumProfit(int[] prices, int k) {
            int n = prices.length;
            // dp[i][j]表示前i天，进行了j次交易所能获得的最大利润
            // dp[i][j] = max(dp[i-1][j], dp[lastI][k-1] + abs(prices[i-1] - prices[lastI])) 0<=lastI<i
            long[][] dp = new long[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = dp[i - 1][j];
                    for (int lastI = 0; lastI < i; lastI++) {
                        dp[i][j] = Math.max(dp[i][j], dp[lastI][j - 1] + Math.abs(prices[i - 1] - prices[lastI]));
                    }
                }
            }
            return dp[n][k];
        }
    }

}
