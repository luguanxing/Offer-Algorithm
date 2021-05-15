package leetcode.problems;

import java.util.Arrays;

public class Test1269_停在原地的方案数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(3, 2));
        System.out.println(new Solution().numWays(2, 4));
        System.out.println(new Solution().numWays(4, 2));
        System.out.println(new Solution().numWays(27, 7));
        System.out.println(new Solution().numWays(438, 315977));
        System.out.println(new Solution().numWays(434, 291270));
        System.out.println(new Solution().numWays(500, 969997));
    }

    static class Solution {
        public int numWays(int steps, int arrLen) {
            int[] dp = new int[arrLen];
            int[] nextDp = new int[arrLen];
            // dp[step][i] = dp[step - 1][i-1] + dp[step - 1][i] + dp[step - 1][i+1]
            dp[0] = 1;
            for (int step = 1; step <= steps; step++) {
                for (int i = 0; i < Math.min(steps, arrLen); i++) {
                    nextDp[i] = (0 <= i - 1 ? dp[i - 1] : 0);
                    nextDp[i] += (dp[i]);
                    nextDp[i] %= 1000000007;
                    nextDp[i] += (i + 1 < arrLen ? dp[i + 1] : 0);
                    nextDp[i] %= 1000000007;
                }
                for (int dpI = 0 ; dpI < arrLen; dpI++) {
                    dp[dpI] = nextDp[dpI];
                }
            }
            return dp[0];
        }
    }

}
