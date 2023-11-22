package leetcode.problems;

import java.util.Arrays;

public class Test2304_网格中的最小路径代价 {

    public static void main(String[] args) {
        // grid = [[5,3],[4,0],[2,1]], moveCost = [[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]
        System.out.println(new Solution().minPathCost(
                new int[][]{{5, 3}, {4, 0}, {2, 1}},
                new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}}
        ));
        // grid = [[5,1,2],[4,0,3]], moveCost = [[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]
        System.out.println(new Solution().minPathCost(
                new int[][]{{5, 1, 2}, {4, 0, 3}},
                new int[][]{{12, 10, 15}, {20, 23, 8}, {21, 7, 1}, {8, 1, 13}, {9, 10, 25}, {5, 3, 2}}
        ));
    }

    static class Solution {
        public int minPathCost(int[][] grid, int[][] moveCost) {
            int height = grid.length;
            int width = grid[0].length;
            int[][] dp = new int[height][width];
            for (int i = 0; i < width; i++) {
                dp[0][i] = grid[0][i];
            }
            for (int i = 1; i < height; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for (int y = 0; y < height - 1; y++) {
                for (int x = 0; x < width; x++) {
                    int current = grid[y][x];
                    for (int z = 0; z < width; z++) {
                        dp[y + 1][z] = Math.min(dp[y + 1][z], grid[y + 1][z] + dp[y][x] + moveCost[current][z]);
                    }
                }
            }
            return Arrays.stream(dp[height - 1]).min().getAsInt();
        }
    }

}
