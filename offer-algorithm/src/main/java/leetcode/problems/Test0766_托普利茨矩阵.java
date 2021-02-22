package leetcode.problems;

public class Test0766_托普利茨矩阵 {

    public static void main(String[] args) {
        System.out.println(new Solution().isToeplitzMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2},
        }));
        System.out.println(new Solution().isToeplitzMatrix(new int[][]{
                {1, 2},
                {2, 2},
        }));
    }

    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            boolean res = true;
            for (int y = 0; y < matrix.length; y++) {
                res &= check(matrix, y, 0, matrix[y][0]);
            }
            for (int x = 0; x < matrix[0].length; x++) {
                res &= check(matrix, 0, x, matrix[0][x]);
            }
            return res;
        }

        private boolean check(int[][] matrix, int y, int x, int val) {
            if (x < 0 || matrix[0].length <= x || y < 0 || matrix.length <= y) {
                return true;
            }
            if (matrix[y][x] == val) {
                return check(matrix, y + 1, x + 1, val);
            } else {
                return false;
            }
        }
    }

}
