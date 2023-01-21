package leetcode.problems;

import java.util.Arrays;

public class Test1824_最少侧跳次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSideJumps(new int[]{0, 1, 2, 3, 0}));
        System.out.println(new Solution().minSideJumps(new int[]{0, 1, 1, 3, 3, 0}));
        System.out.println(new Solution().minSideJumps(new int[]{0, 2, 1, 0, 3, 0}));
        System.out.println(new Solution().minSideJumps(new int[]{0, 0, 3, 1, 0, 1, 0, 2, 3, 1, 0}));
    }

    static class Solution {
        public int minSideJumps(int[] obstacles) {
            int len = obstacles.length;
            // dp[k][i]表示第k行第i列的最少侧跳步数
            int[][] dp = new int[3][len];
            Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
            Arrays.fill(dp[1], Integer.MAX_VALUE / 2);
            Arrays.fill(dp[2], Integer.MAX_VALUE / 2);
            dp[0][0] = 1;
            dp[1][0] = 0;
            dp[2][0] = 1;
            for (int i = 1; i < len; i++) {
                int obstacle = obstacles[i];
                if (obstacle == 0) {
                    // 无障碍，更新所有行
                    dp[0][i] = Math.min(dp[0][i - 1], Math.min(dp[1][i - 1], dp[2][i - 1]) + 1);
                    dp[1][i] = Math.min(dp[1][i - 1], Math.min(dp[0][i - 1], dp[2][i - 1]) + 1);
                    dp[2][i] = Math.min(dp[2][i - 1], Math.min(dp[0][i - 1], dp[1][i - 1]) + 1);
                } else if (obstacle == 1) {
                    // 第0行无法通行，更新第1和第2行
                    dp[1][i] = Math.min(dp[1][i - 1], dp[2][i - 1] + 1);
                    dp[2][i] = Math.min(dp[2][i - 1], dp[1][i - 1] + 1);
                } else if (obstacle == 2) {
                    // 第1行无法通行，更新第0和第2行
                    dp[0][i] = Math.min(dp[0][i - 1], dp[2][i - 1] + 1);
                    dp[2][i] = Math.min(dp[2][i - 1], dp[0][i - 1] + 1);
                } else if (obstacle == 3) {
                    // 第2行无法通行，更新第0和第1行
                    dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1] + 1);
                    dp[1][i] = Math.min(dp[1][i - 1], dp[0][i - 1] + 1);
                }
            }
            return Math.min(dp[0][len - 1], Math.min(dp[1][len - 1], dp[2][len - 1]));
        }
    }

}
