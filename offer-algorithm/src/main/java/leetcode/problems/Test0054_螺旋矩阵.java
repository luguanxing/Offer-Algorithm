package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0054_螺旋矩阵 {

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(
                new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                }
        ));
    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return result;
            }
            // 标识是否已走过
            int height = matrix.length;
            int width = matrix[0].length;
            boolean[][] isVisited = new boolean[height][width];
            // 标识当前点和方向
            int direction = 1;
            int y = 0;
            int x = 0;
            while (0 <= x && x < width && 0 <= y && y < height && !isVisited[y][x]) {
                result.add(matrix[y][x]);
                isVisited[y][x] = true;
                if (direction == 1) {
                    // 继续向右或向下
                    if (x + 1 < width && !isVisited[y][x + 1]) {
                        x += 1;
                    } else {
                        direction = 2;
                        y += 1;
                    }
                } else if (direction == 2) {
                    // 继续向下或向左
                    if (y + 1 < height && !isVisited[y + 1][x]) {
                        y += 1;
                    } else {
                        direction = 3;
                        x -= 1;
                    }
                } else if (direction == 3) {
                    // 继续向左或向上
                    if (0 <= x - 1 && !isVisited[y][x - 1]) {
                        x -= 1;
                    } else {
                        direction = 4;
                        y -= 1;
                    }
                } else {
                    // 继续向上或者向右
                    if (0 <= y - 1 && !isVisited[y - 1][x]) {
                        y -= 1;
                    } else {
                        direction = 1;
                        x += 1;
                    }
                }
            }
            return result;
        }
    }

}
