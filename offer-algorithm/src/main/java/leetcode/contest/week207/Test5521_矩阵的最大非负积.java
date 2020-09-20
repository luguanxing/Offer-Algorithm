package leetcode.contest.week207;

import java.math.BigInteger;

public class Test5521_矩阵的最大非负积 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProductPath(new int[][]{
                {-1, -2, -3},
                {-2, -3, -3},
                {-3, -3, -2},
        }));
        System.out.println(new Solution().maxProductPath(new int[][]{
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1},
        }));
        System.out.println(new Solution().maxProductPath(new int[][]{
                {1, 3},
                {0, -4},
        }));
        System.out.println(new Solution().maxProductPath(new int[][]{
                {1, 4, 4, 0},
                {-2, 0, 0, 1},
                {1, -1, 1, 1},
        }));
        System.out.println(new Solution().maxProductPath(new int[][]{
                {2, 1, 3, 0, -3, 3, -4, 4, 0, -4},
                {-4, -3, 2, 2, 3, -3, 1, -1, 1, -2},
                {-2, 0, -4, 2, 4, -3, -4, -1, 3, 4},
                {-1, 0, 1, 0, -3, 3, -2, -3, 1, 0},
                {0, -1, -2, 0, -3, -4, 0, 3, -2, -2},
                {-4, -2, 0, -1, 0, -3, 0, 4, 0, -3},
                {-3, -4, 2, 1, 0, -4, 2, -4, -1, -3},
                {3, -2, 0, -4, 1, 0, 1, -3, -1, -1},
                {3, -4, 0, 2, 0, -2, 2, -4, -2, 4},
                {0, 4, 0, -3, -4, 3, 3, -1, -2, -2}
        }));
        System.out.println(new Solution().maxProductPath(new int[][]{
                {1, -1, 0, -3, 4, 3, -3, 3, -1, 3, 0, 0, -4, 2},
                {2, -2, -3, -4, 0, -2, -3, 3, 1, 4, 1, -3, -1, -4},
                {-4, 4, -4, -4, 2, -4, 3, 0, -2, -4, 3, 4, -1, 0},
                {-3, 3, -4, -4, 3, 4, 4, 1, -1, -1, 0, 3, 4, 1},
                {1, 3, -4, 2, 2, -3, 1, -3, -4, -4, -1, -4, -4, 4},
                {1, 1, -1, 1, -1, -1, 3, -4, -1, 2, -2, 3, -4, 0},
                {1, 0, 3, 3, 1, 4, 1, 1, -4, -1, -3, 4, -4, 4},
                {4, 3, 2, 3, 0, -1, 2, -4, 1, 0, 0, 1, 3, 4},
                {-4, 4, -4, -4, 2, -2, 2, -1, 0, -2, 2, 4, -2, -1},
                {-2, 3, 4, -4, 3, 3, -2, -1, 0, -3, 4, -2, -1, -4},
                {4, 3, 3, 3, -3, 1, 2, -4, -1, 4, -3, -3, 2, 0},
                {3, 3, 0, 1, -4, -4, -3, 3, -2, -4, 2, 4, -3, 3},
                {-3, 0, 1, 3, 0, 0, 0, -4, -1, 4, -1, -3, 1, 1},
                {-1, 4, 0, -3, 1, -3, -1, 2, 1, -3, -1, -4, 4, 1}
        }));
    }

    static class Solution {
        public int maxProductPath(int[][] grid) {
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            long[][] dpMax = new long[grid.length][grid[0].length];
            long[][] dpMin = new long[grid.length][grid[0].length];
            dpMax[0][0] = grid[0][0];
            dpMin[0][0] = grid[0][0];
            for (int y = 1; y < grid.length; y++) {
                dpMax[y][0] = dpMax[y - 1][0] * grid[y][0];
                dpMin[y][0] = dpMin[y - 1][0] * grid[y][0];
            }
            for (int x = 1; x < grid[0].length; x++) {
                dpMax[0][x] = dpMax[0][x - 1] * grid[0][x];
                dpMin[0][x] = dpMin[0][x - 1] * grid[0][x];
            }
            for (int y = 1; y < grid.length; y++) {
                for (int x = 1; x < grid[0].length; x++) {
                    long res1 = dpMax[y - 1][x] * grid[y][x];
                    long res2 = dpMax[y][x - 1] * grid[y][x];
                    long res3 = dpMin[y - 1][x] * grid[y][x];
                    long res4 = dpMin[y][x - 1] * grid[y][x];
                    max = Math.max(Math.max(res1, res2), Math.max(res3, res4));
                    min = Math.min(Math.min(res1, res2), Math.min(res3, res4));
                    dpMax[y][x] = max;
                    dpMin[y][x] = min;
                }
            }

            long res = dpMax[grid.length - 1][grid[0].length - 1];
            if (res < 0) {
                return -1;
            }
            return (int)(res % 1000000007);
        }
    }

}
