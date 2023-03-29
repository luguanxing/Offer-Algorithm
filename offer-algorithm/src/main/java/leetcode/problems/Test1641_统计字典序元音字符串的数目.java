package leetcode.problems;

public class Test1641_统计字典序元音字符串的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countVowelStrings(1));
        System.out.println(new Solution().countVowelStrings(2));
        System.out.println(new Solution().countVowelStrings(33));
    }

    static class Solution {
        public int countVowelStrings(int n) {
            // dp[c][n]表示c第n位的数量
            // dp[c][i] = sum(dp[c+][n-1])
            int[][] dp = new int[5][n];
            for (int i = 0; i < 5; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] += dp[0][i - 1] + dp[1][i - 1] + dp[2][i - 1] + dp[3][i - 1] + dp[4][i - 1];
                dp[1][i] += dp[1][i - 1] + dp[2][i - 1] + dp[3][i - 1] + dp[4][i - 1];
                dp[2][i] += dp[2][i - 1] + dp[3][i - 1] + dp[4][i - 1];
                dp[3][i] += dp[3][i - 1] + dp[4][i - 1];
                dp[4][i] += dp[4][i - 1];
            }
            return dp[0][n - 1] + dp[1][n - 1] + dp[2][n - 1] + dp[3][n - 1] + dp[4][n - 1];
        }
    }

}
