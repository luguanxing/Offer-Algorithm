package offer;

import java.util.ArrayList;

/*
       1    2   3   4
       5    6   7   8
       9    10  11  12
       13   14  15  16
 */
public class Test29_顺时针打印矩阵 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(new Solution().printMatrix(matrix));
    }

    static class Solution {
        boolean[][] isVistied = null;
        ArrayList<Integer> result = new ArrayList<>();

        public ArrayList<Integer> printMatrix(int[][] matrix) {
            if (matrix == null) {
                return result;
            }
            isVistied = new boolean[matrix.length][matrix[0].length];
            visit(0, 0, 1, matrix);
            return result;
        }

        private void visit(int y, int x, int order, int[][] matrix) {
            // 全都走完就结束
            if (x < 0 || matrix[0].length <= x || y < 0 || matrix.length <= y || isVistied[y][x]) {
                return;
            }
            // 走该点
            isVistied[y][x] = true;
            result.add(matrix[y][x]);
            // 探索下一步的可能性
            if (order == 1) {
                if (x + 1 >= matrix[0].length || isVistied[y][x + 1]) {
                    // 不能继续向右了，改方向向下
                    visit(y + 1, x, 2, matrix);
                } else {
                    // 可以继续向右
                    visit(y, x + 1, 1, matrix);
                }
            } else if (order == 2) {
                if (y + 1 >= matrix.length || isVistied[y + 1][x]) {
                    // 不能继续向下了，改方向向左
                    visit(y, x - 1, 3, matrix);
                } else {
                    // 可以继续向下
                    visit(y + 1, x, 2, matrix);
                }
            } else if (order == 3) {
                if (x - 1 < 0 || isVistied[y][x - 1]) {
                    // 不能继续向左了，改方向向上
                    visit(y - 1, x, 4, matrix);
                } else {
                    // 可以继续向左
                    visit(y, x - 1, 3, matrix);
                }
            } else {
                if (y - 1 < 0 || isVistied[y-1][x]) {
                    // 不能继续向上了，改方向向右
                    visit(y, x + 1, 1, matrix);
                } else {
                    // 可以继续向上
                    visit(y - 1, x, 4, matrix);
                }
            }
        }
    }

}
