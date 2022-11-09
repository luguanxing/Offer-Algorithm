package leetcode.problems;

import java.util.Arrays;

public class Test0764_最大加号标志 {

    public static void main(String[] args) {
        System.out.println(new Solution().orderOfLargestPlusSign(
                5, new int[][]{{4, 2}}
        ));
        System.out.println(new Solution().orderOfLargestPlusSign(
                1, new int[][]{{0, 0}}
        ));
        System.out.println(new Solution().orderOfLargestPlusSign(
                3, new int[][]{{0, 0}}
        ));
    }

    static class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int res = 0;
            int[][] grid = new int[n][n];
            for (int[] row : grid) {
                Arrays.fill(row, 1);
            }
            for (int[] mine : mines) {
                grid[mine[0]][mine[1]] = 0;
            }
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    // 更好的方式是使用dp[y][x][direction]累计各方向连续1的个数
                    if (x - (res - 1) < 0 || x + (res - 1) >= n || y - (res - 1) < 0 || y + (res - 1) >= n) {
                        continue;
                    }
                    for (int k = 1; k <= n / 2 + 1; k++) {
                        if (isOk(n, grid, y, x, k)) {
                            res = Math.max(res, k);
                        } else {
                            break;
                        }
                    }
                }
            }
            return res;
        }

        private boolean isOk(int n, int[][] grid, int y, int x, int k) {
            if (x - (k - 1) < 0 || x + (k - 1) >= n || y - (k - 1) < 0 || y + (k - 1) >= n) {
                return false;
            }
            boolean allOk = grid[y][x] == 1;
            for (int i = 1; i <= k - 1; i++) {
                if (grid[y - i][x] * grid[y + i][x] * grid[y][x - i] * grid[y][x + i] == 0) {
                    allOk = false;
                }
            }
            return allOk;
        }
    }

}
