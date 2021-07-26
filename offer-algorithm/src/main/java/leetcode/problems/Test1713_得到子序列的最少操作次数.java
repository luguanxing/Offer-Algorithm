package leetcode.problems;

import java.util.Arrays;

public class Test1713_得到子序列的最少操作次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(
                new int[]{5, 1, 3},
                new int[]{9, 4, 2, 3, 4}
        ));
        System.out.println(new Solution().minOperations(
                new int[]{6, 4, 8, 1, 3, 2},
                new int[]{4, 7, 6, 2, 3, 8, 6, 1}
        ));
        System.out.println(new Solution().minOperations(
                new int[]{17, 18, 14, 13, 6, 9, 1, 3, 2, 20},
                new int[]{18, 15, 14, 6, 6, 13, 15, 20, 2, 6}
        ));
    }

    static class Solution {
        public int minOperations(int[] target, int[] arr) {
            // 先计算target和arr的最长公共子序列
            int lisLen = getLisLen(target, arr);
            // 再计算需要补多少位成target
            return target.length - lisLen;
        }

        private int getLisLen(int[] s1, int[] s2) {
            // dp[i][j]表示s1[..i]和s2[..j]的lis
            // dp[i][j] = (s1[i]==s2[j])?(dp[i-1][j-1]+1 : max(dp[i-1][j], dp[i][j-1]))
            // 状态压缩
            int[] dp = new int[s2.length];
            dp[0] = s1[0] == s2[0] ? 1 : 0;
            for (int x = 1; x < s2.length; x++) {
                if (s1[0] == s2[x]) {
                    dp[x] = 1;
                } else {
                    dp[x] = dp[x - 1];
                }
            }
            for (int y = 1; y < s1.length; y++) {
                int[] oldDp = Arrays.copyOf(dp, s2.length);
                if (s1[y] == s2[0]) {
                    dp[0] = 1;
                }
                // 注意依赖顺序
                for (int x = 1; x < s2.length; x++) {
                    dp[x] = s1[y] == s2[x] ? oldDp[x - 1] + 1 : Math.max(dp[x], dp[x - 1]);
                }
            }
            return dp[s2.length - 1];
        }
    }

    static class Solution_MLE {
        public int minOperations(int[] target, int[] arr) {
            // 先计算target和arr的最长公共子序列
            int lisLen = getLisLen(target, arr);
            // 再计算需要补多少位成target
            return target.length - lisLen;
        }

        private int getLisLen(int[] s1, int[] s2) {
            // dp[i][j]表示s1[..i]和s2[..j]的lis
            // dp[i][j] = (s1[i]==s2[j])?(dp[i-1][j-1]+1 : max(dp[i-1][j], dp[i][j-1]))
            int[][] dp = new int[s1.length][s2.length];
            dp[0][0] = s1[0] == s2[0] ? 1 : 0;
            for (int x = 1; x < s2.length; x++) {
                if (s1[0] == s2[x]) {
                    dp[0][x] = 1;
                } else {
                    dp[0][x] = dp[0][x - 1];
                }
            }
            for (int y = 1; y < s1.length; y++) {
                if (s1[y] == s2[0]) {
                    dp[y][0] = 1;
                } else {
                    dp[y][0] = dp[y - 1][0];
                }
            }
            for (int y = 1; y < s1.length; y++) {
                for (int x = 1; x < s2.length; x++) {
                    dp[y][x] = s1[y] == s2[x] ? dp[y - 1][x - 1] + 1 : Math.max(dp[y - 1][x], dp[y][x - 1]);
                }
            }
            return dp[s1.length - 1][s2.length - 1];
        }
    }

}
