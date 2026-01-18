package leetcode.problems;

public class Test1895_最大的幻方 {

    public static void main(String[] args) {
        // grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
        System.out.println(new Solution().largestMagicSquare(new int[][]{
                {7, 1, 4, 5, 6},
                {2, 5, 1, 6, 4},
                {1, 5, 4, 3, 2},
                {1, 2, 7, 3, 4}
        }));
        // grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
        System.out.println(new Solution().largestMagicSquare(new int[][]{
                {5, 1, 3, 1},
                {9, 3, 3, 1},
                {1, 3, 3, 8}
        }));
    }

    static class Solution {
        public int largestMagicSquare(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            // dp表示以(i,j)为右下角的幻方的最大边长
            int[][] dp = new int[height][width];
            int max = 1;
            for (int[] row : dp) {
                java.util.Arrays.fill(row, 1);
            }
            for (int r2 = 1; r2 < height; r2++) {
                for (int c2 = 1; c2 < width; c2++) {
                    // 找左上角
                    for (int c1 = 0; c1 < c2; c1++) {
                        for (int r1 = 0; r1 < r2; r1++) {
                            // 判断(r1,c1)到(r2,c2)是否为幻方，其实可以用前缀和优化
                            if (isMagicSquare(grid, r1, c1, r2, c2)) {
                                int len = r2 - r1 + 1;
                                dp[r2][c2] = Math.max(dp[r2][c2], len);
                                max = Math.max(max, dp[r2][c2]);
                            }
                        }
                    }
                }
            }
            return max;
        }

        public boolean isMagicSquare(int[][] grid, int r1, int c1, int r2, int c2) {
            int len = r2 - r1 + 1;
            int targetSum = 0;
            // 计算行和
            for (int r = r1; r <= r2; r++) {
                int rowSum = 0;
                for (int c = c1; c <= c2; c++) {
                    rowSum += grid[r][c];
                }
                if (r == r1) {
                    targetSum = rowSum;
                } else if (rowSum != targetSum) {
                    return false;
                }
            }
            // 计算列和
            for (int c = c1; c <= c2; c++) {
                int colSum = 0;
                for (int r = r1; r <= r2; r++) {
                    colSum += grid[r][c];
                }
                if (colSum != targetSum) {
                    return false;
                }
            }
            // 计算主对角线和
            int diagSum1 = 0;
            for (int i = 0; i < len; i++) {
                diagSum1 += grid[r1 + i][c1 + i];
            }
            if (diagSum1 != targetSum) return false;
            // 计算副对角线和
            int diagSum2 = 0;
            for (int i = 0; i < len; i++) {
                diagSum2 += grid[r1 + i][c2 - i];
            }
            if (diagSum2 != targetSum) return false;
            return true;
        }
    }

}
