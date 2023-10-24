package leetcode.problems;

public class Test1155_掷骰子等于目标和的方法数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numRollsToTarget(1, 6, 3));
        System.out.println(new Solution().numRollsToTarget(2, 6, 7));
        System.out.println(new Solution().numRollsToTarget(30, 30, 500));
    }

    static class Solution {
        public int numRollsToTarget(int n, int k, int target) {
            int MOD = (int) 1E9 + 7;
            // dp[i][t]表示第i次凑t分的方法数
            int[][] dp = new int[n + 1][Math.max(target, k) + 1];
            for (int i = 1; i <= k; i++) {
                dp[1][i] = 1;
            }
            //  dp[i][t] = sum(dp[i-1][t-(1~k)])
            for (int i = 2; i <= n; i++) {
                for (int t = 1; t <= target; t++) {
                    dp[i][t] = 0;
                    for (int j = 1; j <= k; j++) {
                        if (t - j < 0) {
                            break;
                        }
                        dp[i][t] += dp[i - 1][t - j];
                        dp[i][t] %= MOD;
                    }
                }
            }
            return dp[n][target];
        }
    }

}
