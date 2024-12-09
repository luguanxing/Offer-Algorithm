package leetcode.problems;

public class Test0935_骑士拨号器 {

    public static void main(String[] args) {
        System.out.println(new Solution().knightDialer(1)); // 10
        System.out.println(new Solution().knightDialer(2)); // 20
        System.out.println(new Solution().knightDialer(3)); // 46
        System.out.println(new Solution().knightDialer(4)); // 104
        System.out.println(new Solution().knightDialer(3131)); // 136006598
    }

    static class Solution {
        int MOD = (int) 1e9 + 7;

        public int knightDialer(int n) {
            // dp[i][x]表示第i步走到第x位的方法
            int[][] dp = new int[n + 1][10];
            for (int x = 0; x < 10; x++) {
                dp[1][x] = 1;
            }
            for (int i = 2; i <= n; i++) {
                moveFrom(dp, i, 1, 6, 8);
                moveFrom(dp, i, 2, 7, 9);
                moveFrom(dp, i, 3, 4, 8);
                moveFrom(dp, i, 4, 3, 9, 0);
                moveFrom(dp, i, 6, 1, 7, 0);
                moveFrom(dp, i, 7, 6, 2);
                moveFrom(dp, i, 8, 1, 3);
                moveFrom(dp, i, 9, 2, 4);
                moveFrom(dp, i, 0, 4, 6);
            }
            int sum = 0;
            for (int x = 0; x < 10; x++) {
                sum += dp[n][x];
                sum %= MOD;
            }
            return sum;
        }

        public void moveFrom(int[][] dp, int i, int to, int... froms) {
            for (int from : froms) {
                dp[i][to] += dp[i - 1][from];
                dp[i][to] %= MOD;
            }
        }
    }

}
