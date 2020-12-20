package leetcode.problems;

public class Test0048_旋转图像 {

    public static void main(String[] args) {
        int[][] martix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        new Solution().rotate(martix);
        System.out.println(martix);
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            // 先对角线翻转
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
            // 再竖着翻转
            int mid = n / 2;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < mid; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = tmp;
                }
            }
        }
    }

    static class Solution_duplicateMartix {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] mat = new int[n][n];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    mat[x][n - 1 - y] = matrix[y][x];
                }
            }
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    matrix[y][x] = mat[y][x];
                }
            }
        }
    }

}
