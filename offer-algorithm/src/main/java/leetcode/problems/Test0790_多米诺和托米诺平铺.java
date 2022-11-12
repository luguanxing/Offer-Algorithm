package leetcode.problems;

public class Test0790_多米诺和托米诺平铺 {

    public static void main(String[] args) {
        System.out.println(new Solution().numTilings(2));
        System.out.println(new Solution().numTilings(3));
        System.out.println(new Solution().numTilings(4));
        System.out.println(new Solution().numTilings(5));
        System.out.println(new Solution().numTilings(6));
        System.out.println(new Solution().numTilings(7));
    }

    static class Solution {
        public int numTilings(int n) {
            // dp[i]之前的全部覆盖满
            // dp[i][0]表示i格无覆盖
            // dp[i][1]表示i格上覆盖
            // dp[i][2]表示i格下覆盖
            // dp[i][3]表示i格全覆盖
            int MOD = 1000000007;
            long[][] dp = new long[Math.max(n + 1, 4)][4];
            dp[1][0] = 1;
            dp[1][1] = 0;
            dp[1][2] = 0;
            dp[1][3] = 1;
            for (int i = 2; i <= n; i++) {
                // i-1格无覆盖+竖2格
                dp[i][0] = dp[i - 1][3];
                dp[i][0] %= MOD;
                // i-1格下覆盖+横2格 i-1格无覆盖+3格L1
                dp[i][1] = dp[i - 1][2] + dp[i - 1][0];
                dp[i][1] %= MOD;
                // i-1格上覆盖+横2格 i-1格无覆盖+3格L2
                dp[i][2] = dp[i - 1][1] + dp[i - 1][0];
                dp[i][2] %= MOD;
                // i-1格无覆盖+2横2格 i-1格无覆盖+2竖2格 i-1格上覆盖+3格L1 i-1格下覆盖+3格L2 i-1格全覆盖+竖2格
                dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
                dp[i][3] %= MOD;
            }
            return (int) dp[n][3];
        }
    }

    static class Solution_Test {
        public int numTilings(int n) {
            int[] dp = new int[Math.max(n + 1, 4)];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 5;
            // dp[i] = A * dp[i-1] + B * dp[i-2] + C * dp[i-3]
            // 根据用例可解三元一次方程组系数A=2, B=0, C=1
            // dp[i] = 2 * dp[i-1] + 0 * dp[i-2] + 1 * dp[i-3]
            for (int i = 4; i <= n; i++) {
                long sum = 2L * dp[i - 1] + dp[i - 3];
                dp[i] = (int) (sum % 1000000007);
            }
            return dp[n];
        }
    }

}
