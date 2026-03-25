package leetcode.problems;

import java.util.Arrays;

public class Test3546_等和矩阵分割I {

    public static void main(String[] args) {
        // grid = [[1,4],[2,3]]
        System.out.println(new Solution().canPartitionGrid(new int[][]{
                {1, 4},
                {2, 3}
        }));
        // grid = [[1,3],[2,4]]
        System.out.println(new Solution().canPartitionGrid(new int[][]{
                {1, 3},
                {2, 4}
        }));
    }

    static class Solution_更快 {
        public boolean canPartitionGrid(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            long total = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    total += grid[i][j];
                }
            }

            long sum = 0;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    sum += grid[i][j];
                }
                if (sum * 2 == total) return true;
            }

            sum = 0;
            for (int j = 0; j < n - 1; j++) {
                for (int i = 0; i < m; i++) {
                    sum += grid[i][j];
                }
                if (sum * 2 == total) return true;
            }

            return false;
        }
    }

    static class Solution {
        public boolean canPartitionGrid(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            long[] colPrefixSum = new long[width + 1];
            long[] rowPrefixSum = new long[height + 1];
            for (int y = 0; y < height; y++) {
                long rowSum = 0;
                for (int x = 0; x < width; x++) {
                    rowSum += grid[y][x];
                }
                rowPrefixSum[y + 1] = rowPrefixSum[y] + rowSum;
            }
            for (int x = 0; x < width; x++) {
                long colSum = 0;
                for (int y = 0; y < height; y++) {
                    colSum += grid[y][x];
                }
                colPrefixSum[x + 1] = colPrefixSum[x] + colSum;
            }
            // 尝试每个分割点
            for (int col = 1; col < width; col++) {
                long leftSum = colPrefixSum[col];
                long rightSum = colPrefixSum[width] - leftSum;
                if (leftSum == rightSum) {
                    return true;
                }
            }
            for (int row = 1; row < height; row++) {
                long topSum = rowPrefixSum[row];
                long bottomSum = rowPrefixSum[height] - topSum;
                if (topSum == bottomSum) {
                    return true;
                }
            }
            return false;
        }
    }

}
