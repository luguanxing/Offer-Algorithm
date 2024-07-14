package leetcode.problems;

import java.util.*;

public class Test0807_保持城市天际线 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxIncreaseKeepingSkyline(
                new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}
        ));
    }

    static class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int res = 0;
            // 计算城市横向和纵向天际线
            int[] rowMaxs = new int[height];
            int[] colMaxs = new int[width];
            for (int y = 0; y < height; y++) {
                int[] row = grid[y];
                int rowMax = Arrays.stream(row).max().getAsInt();
                rowMaxs[y] = rowMax;
            }
            for (int x = 0; x < width; x++) {
                int colMax = 0;
                for (int y = 0; y < height; y++) {
                    colMax = Math.max(colMax, grid[y][x]);
                }
                colMaxs[x] = colMax;
            }
            // 计算增量和
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    res += Math.min(rowMaxs[y], colMaxs[x]) - grid[y][x];
                }
            }
            return res;
        }
    }

    static class Solution_OLD {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int[] north = new int[width];
            int[] west = new int[height];
            for (int x = 0; x < width; x++) {
                int max = 0;
                for (int y = 0; y < height; y++) {
                    max = Math.max(max, grid[y][x]);
                }
                north[x] = max;
            }
            for (int y = 0; y < height; y++) {
                int max = 0;
                for (int x = 0; x < width; x++) {
                    max = Math.max(max, grid[y][x]);
                }
                west[y] = max;
            }
            int res = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    res += Math.min(north[x], west[y]) - grid[y][x];
                }
            }
            return res;
        }
    }

}
