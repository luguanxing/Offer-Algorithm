package leetcode.problems;

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
