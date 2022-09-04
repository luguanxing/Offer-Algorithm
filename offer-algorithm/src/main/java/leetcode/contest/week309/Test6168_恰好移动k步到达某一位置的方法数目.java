package leetcode.contest.week309;

public class Test6168_恰好移动k步到达某一位置的方法数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfWays(1, 2, 3));
        System.out.println(new Solution().numberOfWays(2, 5, 10));
        System.out.println(new Solution().numberOfWays(1, 1000, 999));
        System.out.println(new Solution().numberOfWays(1, 3, 2));
        System.out.println(new Solution().numberOfWays(272, 270, 6));
        System.out.println(new Solution().numberOfWays(5, 3, 6));
        System.out.println(new Solution().numberOfWays(3, 5, 6));
        System.out.println(new Solution().numberOfWays(1, 3, 6));
        System.out.println(new Solution().numberOfWays(1, 30000, 6));
    }

    static class Solution {
        public int numberOfWays(int startPos, int endPos, int k) {
            // dp[i][k]表示用k步走到第i个长度的方法数
            int MOD = 1000000007;
            int len = Math.abs(endPos - startPos) + 1;
            long[][] dp = new long[k + 1][k + 1];
            // dp[i][k] = dp[i-1][k-1] + dp[i+1][k-1]
            // 从dp[len][0]开始计算到dp[2*len][k]
            dp[0][0] = 1;
            for (int step = 1; step <= k; step++) {
                for (int pos = 0; pos <= k; pos++) {
                    if (pos != 0) {
                        dp[pos][step] += dp[pos - 1][step - 1];
                        dp[pos][step] %= MOD;
                        dp[pos][step] += pos == k ? 0 : dp[pos + 1][step - 1];
                        dp[pos][step] %= MOD;
                    } else {
                        dp[pos][step] = 2 * dp[pos + 1][step - 1];
                        dp[pos][step] %= MOD;
                    }
                }
            }
            return len - 1 > k ? 0 : (int) dp[len - 1][k];
        }
    }

}
