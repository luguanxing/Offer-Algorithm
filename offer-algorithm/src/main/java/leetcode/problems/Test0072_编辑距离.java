package leetcode.problems;

public class Test0072_编辑距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance(
                "horse", "ros"
        ));
        System.out.println(new Solution().minDistance(
                "intention", "execution"
        ));
    }

    static class Solution {
        public int minDistance(String s1, String s2) {
            int len1 = s1.length();
            int len2 = s2.length();
            // 定义dp[i][j]是s1[0-i]和s2[0-j]的最小编辑距离
            int[][] dp = new int[len1 + 1][len2 + 1];
            // 设置base case
            for (int y = 1; y <= len1; y++) {
                dp[y][0] = y;
            }
            for (int x = 1; x <= len2; x++) {
                dp[0][x] = x;
            }
            // 动态推导计算相同时跳过，不相同时增、删、换的最小值
            // dp[i][j] = (s1[i]==s2[j] ? dp[i-1][j-1] : min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]+1))
            for (int y = 1; y <= len1; y++) {
                for (int x = 1; x <= len2; x++) {
                    if (s1.charAt(y - 1) == s2.charAt(x - 1)) {
                        dp[y][x] = dp[y - 1][x - 1];
                    } else {
                        dp[y][x] = dp[y][x - 1] + 1;
                        dp[y][x] = Math.min(dp[y][x], dp[y - 1][x] + 1);
                        dp[y][x] = Math.min(dp[y][x], dp[y - 1][x - 1] + 1);
                    }
                }
            }
            return dp[len1][len2];
        }
    }

}
