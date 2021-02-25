package leetcode.problems;

import java.util.Arrays;

public class Test0867_转置矩阵 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        })));
    }

    static class Solution {
        public int[][] transpose(int[][] matrix) {
            int height = matrix.length;
            int width = matrix[0].length;
            int[][] res = new int[width][height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    res[x][y] = matrix[y][x];
                }
            }
            return res;
        }
    }

}
