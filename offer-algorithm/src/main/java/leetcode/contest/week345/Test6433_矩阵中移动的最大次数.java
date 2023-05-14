package leetcode.contest.week345;

import java.util.Arrays;

public class Test6433_矩阵中移动的最大次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxMoves(new int[][]{
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        }));
        System.out.println(new Solution().maxMoves(new int[][]{
                {3, 2, 4},
                {2, 1, 9},
                {1, 1, 7}
        }));
        System.out.println(new Solution().maxMoves(new int[][]{
                {187, 167, 209, 251, 152, 236, 263, 128, 135},
                {267, 249, 251, 285, 73, 204, 70, 207, 74},
                {189, 159, 235, 66, 84, 89, 153, 111, 189},
                {120, 81, 210, 7, 2, 231, 92, 128, 218},
                {193, 131, 244, 293, 284, 175, 226, 205, 245}
        }));
    }

    static class Solution {
        public int maxMoves(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int[][] dp = new int[height][width];
            for (int y = 0; y < height; y++) {
                dp[y][0] = 1;
            }
            for (int x = 1; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    // 左上
                    if (0 <= y - 1 && 0 < dp[y - 1][x - 1] && grid[y - 1][x - 1] < grid[y][x]) {
                        dp[y][x] = Math.max(dp[y][x], dp[y - 1][x - 1] + 1);
                    }
                    // 左
                    if (0 < dp[y][x - 1] && grid[y][x - 1] < grid[y][x]) {
                        dp[y][x] = Math.max(dp[y][x], dp[y][x - 1] + 1);
                    }
                    // 左下
                    if (y + 1 < height && 0 < dp[y + 1][x - 1] && grid[y + 1][x - 1] < grid[y][x]) {
                        dp[y][x] = Math.max(dp[y][x], dp[y + 1][x - 1] + 1);
                    }
                }
            }
            int res = 0;
            for (int y = 0; y < height; y++) {
                res = Math.max(res, Arrays.stream(dp[y]).max().getAsInt());
            }
            return res > 0 ? res - 1 : 0;
        }
    }

}
