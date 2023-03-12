package leetcode.contest.week335;

import java.util.Arrays;
import java.util.Comparator;

public class Test6310_获得分数的方法数 {

    public static void main(String[] args) {
        System.out.println(new Solution().waysToReachTarget(
                6, new int[][]{{6, 1}, {3, 2}, {2, 3}}
        ));
        System.out.println(new Solution().waysToReachTarget(
                5, new int[][]{{50, 1}, {50, 2}, {50, 5}}
        ));
        System.out.println(new Solution().waysToReachTarget(
                18, new int[][]{{6, 1}, {3, 2}, {2, 3}}
        ));
    }

    static class Solution {
        public int waysToReachTarget(int target, int[][] types) {
            int MOD = 1000000007;
            Arrays.sort(types, Comparator.comparingInt(o -> o[1]));
            // dp(i, m)前i件物品拿m分的方法数
            // dp(i, m) = dp(i-1, m-数量范围*分数);
            int[][] dp = new int[55][55 * 55];
            for (int i = 0; i <= types[0][0]; i++) {
                dp[0][i * types[0][1]] = 1;
            }
            for (int i = 1; i < types.length; i++) {
                int count = types[i][0];
                int score = types[i][1];
                for (int s = 0; s < 55 * 55; s++) {
                    for (int j = 0; j <= count; j++) {
                        if (s - j * score >= 0) {
                            dp[i][s] += dp[i - 1][s - j * score];
                            dp[i][s] %= MOD;
                        }
                    }
                }
            }
            return dp[types.length-1][target];
        }
    }

}
