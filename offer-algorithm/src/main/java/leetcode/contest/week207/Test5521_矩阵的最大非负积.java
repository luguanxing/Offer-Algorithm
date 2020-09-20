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
        BigInteger max = new BigInteger(Integer.MIN_VALUE + "");
        BigInteger[][] dpMax = null;
        BigInteger[][] dpMin = null;

        public int maxProductPath(int[][] grid) {
            dpMax = new BigInteger[grid.length][grid[0].length];
            dpMin = new BigInteger[grid.length][grid[0].length];
            dpMax[0][0] = new BigInteger(grid[0][0] + "");
            dpMin[0][0] = new BigInteger(grid[0][0] + "");
            for (int y = 1; y < grid.length; y++) {
                dpMax[y][0] = dpMax[y - 1][0].multiply(new BigInteger(grid[y][0] + ""));
                dpMin[y][0] = dpMin[y - 1][0].multiply(new BigInteger(grid[y][0] + ""));
            }
            for (int x = 1; x < grid[0].length; x++) {
                dpMax[0][x] = dpMax[0][x - 1].multiply(new BigInteger(grid[0][x] + ""));
                dpMin[0][x] = dpMin[0][x - 1].multiply(new BigInteger(grid[0][x] + ""));
            }
            for (int y = 1; y < grid.length; y++) {
                for (int x = 1; x < grid[0].length; x++) {
                    BigInteger res1 = dpMax[y - 1][x].multiply(new BigInteger(grid[y][x] + ""));
                    BigInteger res2 = dpMax[y][x - 1].multiply(new BigInteger(grid[y][x] + ""));
                    BigInteger res3 = dpMin[y - 1][x].multiply(new BigInteger(grid[y][x] + ""));
                    BigInteger res4 = dpMin[y][x - 1].multiply(new BigInteger(grid[y][x] + ""));
                    BigInteger max = res1;
                    if (max.compareTo(res2) < 0) {
                        max = res2;
                    }
                    if (max.compareTo(res3) < 0) {
                        max = res3;
                    }
                    if (max.compareTo(res4) < 0) {
                        max = res4;
                    }
                    BigInteger min = res1;
                    if (min.compareTo(res2) > 0) {
                        min = res2;
                    }
                    if (min.compareTo(res3) > 0) {
                        min = res3;
                    }
                    if (min.compareTo(res4) > 0) {
                        min = res4;
                    }
                    dpMax[y][x] = max;
                    dpMin[y][x] = min;
                }
            }

            if (dpMax[grid.length - 1][grid[0].length - 1].compareTo(new BigInteger("0")) < 0) {
                return -1;
            }
            return dpMax[grid.length - 1][grid[0].length - 1].mod(new BigInteger("1000000007")).intValue();
        }
    }

}
