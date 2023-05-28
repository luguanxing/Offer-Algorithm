package leetcode.contest.week347;

public class Test6455_使所有字符相等的最小成本 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumCost("0"));
        System.out.println(new Solution().minimumCost("0011"));
        System.out.println(new Solution().minimumCost("010101"));
    }

    static class Solution {
        public long minimumCost(String s) {
            if (s.isEmpty() || s.length() == 1) {
                return 0;
            }
            int len = s.length();
            String half1 = s.substring(0, len / 2);
            String half2 = s.substring(len / 2);
            long[][] dp1 = getCost(half1);
            long[][] dp2 = getCost(new StringBuilder(half2).reverse().toString());
            return Math.min(
                    dp1[half1.length() - 1][0] + dp2[half2.length() - 1][0],
                    dp1[half1.length() - 1][1] + dp2[half2.length() - 1][1]
            );
        }

        private long[][] getCost(String s) {
            int len = s.length();
            // dp[i][0]表示前i个字符变0代价
            // dp[i][1]表示前i个字符变1代价
            long[][] dp = new long[len][2];
            dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
            dp[0][1] = s.charAt(0) == '1' ? 0 : 1;

            for (int i = 1; i < len; i++) {
                if (s.charAt(i) == '0') {
                    dp[i][0] = Math.min(
                            dp[i - 1][0],
                            dp[i - 1][1] + i
                    );
                    dp[i][1] = Math.min(
                            dp[i - 1][1] + i + i + 1,
                            dp[i - 1][0] + i + 1
                    );
                } else if (s.charAt(i) == '1') {
                    dp[i][0] = Math.min(
                            dp[i - 1][1] + i + 1,
                            dp[i - 1][0] + i + i + 1
                    );
                    dp[i][1] = Math.min(
                            dp[i - 1][1],
                            dp[i - 1][0] + i
                    );
                }
            }

            return dp;
        }
    }

}
