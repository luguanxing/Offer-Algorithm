package leetcode.problems;

import java.util.Arrays;

public class Test0931_下降路径最小和 {

    public static void main(String[] args) {
        System.out.println(new Solution().minFallingPathSum(new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        }));
        System.out.println(new Solution().minFallingPathSum(new int[][]{
                {-19, 57},
                {-40, -5}
        }));
    }

    static class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int height = matrix.length;
            int width = matrix[0].length;
            for (int x = 0; x < width; x++) {
                matrix[0][x] = matrix[0][x];
            }
            for (int y = 1; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int min = Integer.MAX_VALUE;
                    if (x - 1 >= 0) {
                        min = Math.min(min, matrix[y - 1][x - 1]);
                    }
                    min = Math.min(min, matrix[y - 1][x]);
                    if (x + 1 < width) {
                        min = Math.min(min, matrix[y - 1][x + 1]);
                    }
                    matrix[y][x] = min + matrix[y][x];
                }
            }
            return Arrays.stream(matrix[height - 1]).min().getAsInt();
        }
    }

}
