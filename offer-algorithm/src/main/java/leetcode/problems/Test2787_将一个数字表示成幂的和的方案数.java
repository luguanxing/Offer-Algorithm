package leetcode.problems;

import java.util.*;

public class Test2787_将一个数字表示成幂的和的方案数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfWays(10, 2));
        System.out.println(new Solution().numberOfWays(4, 1));
    }

    static class Solution {
        public int numberOfWays(int n, int x) {
            // 背包问题，用dp[i][j]表示用前i个数字选和为j的方法数
            long[][] dp = new long[n + 1][n + 1];
            int MOD = (int) 1e9 + 7;
            dp[0][0] = 1;
            // dp[i][j] = dp[i-1][j] + dp[i-1][j - i^x]
            for (int i = 1; i <= n; i++) {
                long pow = (long) Math.pow(i, x);
                for (int j = 0; j <= n; j++) {
                    // 不选i
                    dp[i][j] += dp[i-1][j];
                    // 选i
                    if (j >= pow) {
                        dp[i][j] += dp[i-1][(int) (j - pow)];
                    }
                    dp[i][j] %= MOD;
                }
            }
            return (int) dp[n][n];
        }
    }

    static class Solution_暴力DFS {
        int res = 0;

        public int numberOfWays(int n, int x) {
            dfs(1, n, x, new ArrayList<>());
            return res;
        }

        private void dfs(int idx, int n, int x, List<Integer> current) {
            if (n == 0) {
                System.out.println(current);
                res++;
                return;
            }
            if (n < 0 || Math.pow(idx, x) > n) {
                return;
            }
            // 不要idx
            dfs(idx + 1, n, x, current);
            // 要idx
            int pow = (int) Math.pow(idx, x);
            current.add(idx);
            dfs(idx + 1, n - pow, x, current);
            current.remove(current.size() - 1);
        }
    }

}
