package leetcode.problems;

public class Test3652_按策略买卖股票的最佳时机 {

    public static void main(String[] args) {
        // prices = [4,2,8], strategy = [-1,0,1], k = 2
        System.out.println(new Solution().maxProfit(
                new int[]{4, 2, 8},
                new int[]{-1, 0, 1},
                2
        ));
        // prices = [5,4,3], strategy = [1,1,0], k = 2
        System.out.println(new Solution().maxProfit(
                new int[]{5, 4, 3},
                new int[]{1, 1, 0},
                2
        ));
        // prices = [1..100000], strategy = [1, -1]*50000, k = 99998
        int[] prices = new int[100000];
        int[] strategy = new int[100000];
        for (int i = 0; i < 100000; i++) {
            prices[i] = i + 1;
            strategy[i] = (i % 2 == 0) ? 1 : -1;
        }
        System.out.println(new Solution().maxProfit(
                prices,
                strategy,
                99998
        ));
    }

    static class Solution {
        public long maxProfit(int[] prices, int[] strategy, int k) {
            int len = prices.length;
            // 先计算原始总和
            long sum = 0;
            for (int i = 0; i < len; i++) {
                sum += prices[i] * strategy[i];
            }
            // 滑动k窗口看最大差值
            long diff = 0;
            for (int i = 0; i < k; i++) {
                if (i < k / 2) {
                    // strategy[i] -> 0，原来是prices[i] * strategy[i]，现在变成prices[i] * 0
                    diff += prices[i] * (0 - strategy[i]);
                } else {
                    // strategy[i] -> 1，原来是prices[i] * strategy[i]，现在变成prices[i] * 1
                    diff += prices[i] * (1 - strategy[i]);
                }
            }
            long maxDiff = Math.max(diff, 0);
            for (int i = k; i < len; i++) {
                // 加入新元素i, strategy[i] -> 1，原来是prices[i] * strategy[i]，现在变成prices[i] * 1
                diff += prices[i] * (1 - strategy[i]);
                // 移除旧元素i-k,  0 -> strategy[i-k]，原来是prices[i-k] * 0，现在变成prices[i-k] * strategy[i]
                diff += prices[i - k] * (strategy[i - k] - 0);
                // 中间元素i-k/2， 1->0， 原来是prices[i - k/2] * 0，现在变成prices[i - k/2] * 1
                diff += prices[i - k / 2] * (0 - 1);
                // 更新最大差值
                maxDiff = Math.max(maxDiff, diff);
            }
            return sum + maxDiff;
        }
    }

}
