package leetcode.problems;

public class Test2110_股票平滑下跌阶段的数目 {

    public static void main(String[] args) {
        // prices = [3,2,1,4]
        System.out.println(new Solution().getDescentPeriods(new int[]{3, 2, 1, 4}));
        // prices = [8,6,7,7]
        System.out.println(new Solution().getDescentPeriods(new int[]{8, 6, 7, 7}));
        // prices = [1]
        System.out.println(new Solution().getDescentPeriods(new int[]{1}));
    }

    static class Solution {
        public long getDescentPeriods(int[] prices) {
            // dp[i] 表示 以 prices[i] 结尾的平滑下跌阶段数目
            // dp[i] = dp[i-1] + 1 if prices[i] == prices[i-1] - 1 else 1
            // res = sum(dp) 累加时可以不使用 dp 数组，使用变量记录上一个状态即可
            long res = 1;
            int last = prices[0];
            int lastCnt = 1;
            for (int i = 1; i < prices.length; i++) {
                int price = prices[i];
                if (price == last - 1) {
                    lastCnt++;
                } else {
                    lastCnt = 1;
                }
                res += lastCnt;
                last = price;
            }
            return res;
        }
    }

}
