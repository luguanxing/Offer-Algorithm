package leetcode.contest.week387;

public class Test100234_在矩阵上写出字母Y所需的最少操作次数 {

    public static void main(String[] args) {
        // grid = [[1,2,2],[1,1,0],[0,1,0]]
        System.out.println(new Solution().minimumOperationsToWriteY(new int[][]{{1, 2, 2}, {1, 1, 0}, {0, 1, 0}}));
        // grid = [[0,1,0,1,0],[2,1,0,1,2],[2,2,2,0,1],[2,2,2,2,2],[2,1,2,2,2]]
        System.out.println(new Solution().minimumOperationsToWriteY(new int[][]{{0, 1, 0, 1, 0}, {2, 1, 0, 1, 2}, {2, 2, 2, 0, 1}, {2, 2, 2, 2, 2}, {2, 1, 2, 2, 2}}));
    }

    static class Solution {
        public int minimumOperationsToWriteY(int[][] grid) {
            int n = grid.length;
            int minOperations = Integer.MAX_VALUE;

            // 枚举所有可能的 Y 值和非 Y 值
            for (int yValue = 0; yValue <= 2; yValue++) {
                for (int nonYValue = 0; nonYValue <= 2; nonYValue++) {
                    if (yValue == nonYValue) {
                        // Y 的值和非 Y 的值不能相同
                        continue;
                    }

                    int operations = 0;
                    for (int y = 0; y < n; y++) {
                        for (int x = 0; x < n; x++) {
                            if (isPartOfY(y, x, n)) {
                                // 如果是 Y 的一部分但值不匹配
                                if (grid[y][x] != yValue) {
                                    operations++;
                                }
                            } else {
                                // 如果不是 Y 的一部分但值不匹配
                                if (grid[y][x] != nonYValue) {
                                    operations++;
                                }
                            }
                        }
                    }
                    minOperations = Math.min(minOperations, operations);
                }
            }
            return minOperations;
        }

        // 判断单元格是否属于 Y 的一部分
        private boolean isPartOfY(int y, int x, int n) {
            int center = n / 2;
            // 检查是否在从左上角到中心的对角线上
            if (y == x && y <= center) {
                return true;
            }
            // 检查是否在从右上角到中心的对角线上
            if (y + x == n - 1 && y <= center) {
                return true;
            }
            // 检查是否在从中心到底部的垂直线上
            if (x == center && y >= center) {
                return true;
            }
            return false;
        }
    }


}
