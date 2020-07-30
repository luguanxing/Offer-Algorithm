package leetcode.problems;

public class Test0343_整数拆分 {

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(2));
        System.out.println(new Solution().integerBreak(10));
    }

    static class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 3];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 2;
            for (int i = 4; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(dp[i - j], i - j));
                }
            }
            return dp[n];
        }
    }

}
