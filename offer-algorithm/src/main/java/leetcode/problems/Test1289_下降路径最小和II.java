package leetcode.problems;

import java.util.Arrays;

public class Test1289_下降路径最小和II {

    public static void main(String[] args) {
        System.out.println(new Solution().minFallingPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }

    static class Solution {
        public int minFallingPathSum(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            for (int y = 1; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int upMin = Integer.MAX_VALUE;
                    for (int k = 0; k < width; k++) {
                        if (k == x) {
                            continue;
                        }
                        upMin = Math.min(upMin, grid[y - 1][k]);
                    }
                    grid[y][x] += upMin;
                }
            }
            return Arrays.stream(grid[height - 1]).min().getAsInt();
        }
    }

}
