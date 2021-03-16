package leetcode.problems;

import java.util.Arrays;

public class Test0059_螺旋矩阵II {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().generateMatrix(3)));
        System.out.println(Arrays.toString(new Solution().generateMatrix(4)));
    }

    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int[][] matrix = new int[n][n];
            int pos = 0;
            int y = 0;
            int x = 0;
            int index = 1;
            while (index <= n * n) {
                matrix[y][x] = index++;
                for (int i = 0; i < directions.length; i++) {
                    // 先尝试往之前的方向继续走，不能走再试其它方向
                    int[] direction = directions[pos];
                    int nextY = y + direction[0];
                    int nextX = x + direction[1];
                    if (nextX < 0 || n <= nextX || nextY < 0 || n <= nextY || matrix[nextY][nextX] != 0) {
                        pos = (pos + 1) % directions.length;
                        continue;
                    }
                    y = nextY;
                    x = nextX;
                    break;
                }
            }
            return matrix;
        }
    }

}
