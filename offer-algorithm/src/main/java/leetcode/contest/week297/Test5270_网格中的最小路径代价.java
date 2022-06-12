package leetcode.contest.week297;

import java.util.Arrays;

public class Test5270_网格中的最小路径代价 {

    public static void main(String[] args) {
        System.out.println(new Solution().minPathCost(
                new int[][]{{5, 3}, {4, 0}, {2, 1}},
                new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}}
        ));
        System.out.println(new Solution().minPathCost(
                new int[][]{{5, 1, 2}, {4, 0, 3}},
                new int[][]{{12, 10, 15}, {20, 23, 8}, {21, 7, 1}, {8, 1, 13}, {9, 10, 25}, {5, 3, 2}}
        ));
    }

    static class Solution {
        public int minPathCost(int[][] grid, int[][] moveCost) {
            // dp[i][j]表示到第i层j列的 最小代价
            // dp[i][j] = Math.min(dp[i-1][k]+cost[k][j])
            int height = grid.length;
            int width = grid[0].length;
            int[][] dp = new int[height][width];
            for (int i = 0; i < width; i++) {
                dp[0][i] = grid[0][i];
            }
            for (int y = 1; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int min = Integer.MAX_VALUE;
                    for (int lastX = 0; lastX < width; lastX++) {
                        int lastCost = dp[y - 1][lastX];
                        int currentGrid = grid[y][x];
                        int currentMove = moveCost[grid[y - 1][lastX]][x];
                        min = Math.min(min, lastCost + currentGrid + currentMove);
                    }
                    dp[y][x] = min;
                }
            }
            return Arrays.stream(dp[height - 1]).min().getAsInt();
        }
    }

}
