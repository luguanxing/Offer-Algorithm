package leetcode.contest.week250;

import java.util.Arrays;

public class Test5815_扣分后的最大得分 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxPoints(new int[][]{
                {1, 2, 3},
                {1, 5, 1},
                {3, 1, 1}
        }));
        System.out.println(new Solution().maxPoints(new int[][]{
                {1, 5},
                {2, 3},
                {4, 2}
        }));
        System.out.println(new Solution().maxPoints(new int[][]{
                {4, 1, 0, 4, 0},
                {1, 0, 4, 0, 5},
                {1, 3, 0, 4, 1},
                {4, 4, 0, 4, 0}
        }));
    }

    static class Solution {
        public long maxPoints(int[][] points) {
            int height = points.length;
            int width = points[0].length;
            long[][] dp = new long[height][width];
            for (int x = 0; x < width; x++) {
                dp[0][x] = points[0][x];
            }
            for (int y = 1; y < height; y++) {
                long leftMax = 0;
                for (int x = 0; x < width; x++) {
                    leftMax = Math.max(leftMax, dp[y - 1][x] + x);
                    dp[y][x] = Math.max(dp[y][x], points[y][x] - x + leftMax);
                }
                long rightMax = points[y - 1][width - 1] - (width - 1);
                for (int x = width - 1; x >= 0; x--) {
                    dp[y][x] = Math.max(dp[y][x], points[y][x] + x + rightMax);
                    rightMax = Math.max(rightMax, dp[y - 1][x] - x);
                }
            }
            return Arrays.stream(dp[height - 1]).max().orElse(0);
        }
    }

    static class Solution_TLE {
        public long maxPoints(int[][] points) {
            int height = points.length;
            int width = points[0].length;
            long[][] dp = new long[height][width];
            for (int x = 0; x < width; x++) {
                dp[0][x] = points[0][x];
            }
            for (int y = 1; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    for (int z = 0; z < width; z++) {
                        dp[y][x] = Math.max(dp[y][x], points[y][x] + dp[y - 1][z] - Math.abs(x - z));
                    }
                }
            }
            return Arrays.stream(dp[height - 1]).max().orElse(0);
        }
    }

}
