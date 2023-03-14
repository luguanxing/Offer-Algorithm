package leetcode.problems;

import java.util.Arrays;

public class Test1605_给定行和列的和求可行矩阵 {

    public static void main(String[] args) {
        new Solution().restoreMatrix(
                new int[]{3, 8},
                new int[]{4, 7}
        );
        new Solution().restoreMatrix(
                new int[]{5, 7, 10},
                new int[]{8, 6, 8}
        );
        new Solution().restoreMatrix(
                new int[]{14, 9},
                new int[]{6, 9, 8}
        );
    }

    static class Solution {
        public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            int height = rowSum.length;
            int width = colSum.length;
            int[][] res = new int[height][width];
            fill(0, 0, res, rowSum, colSum);
            return res;
        }

        private void fill(int y, int x, int[][] res, int[] rowSum, int[] colSum) {
            if (y == rowSum.length || x == colSum.length) {
                return;
            }
            // 使用贪心，从左上角开始填
            // 从rowSum[y], colSum[x]中选出最大的，这样选中的对应的行或列都是0了
            int max = Math.min(rowSum[y], colSum[x]);
            int nextY = y;
            int nextX = x;
            rowSum[y] -= max;
            colSum[x] -= max;
            res[y][x] = max;
            if (rowSum[y] == 0) {
                nextY++;
            }
            if (colSum[x] == 0) {
                nextX++;
            }
            fill(nextY, nextX, res, rowSum, colSum);
        }
    }

}
