package leetcode.problems;

import java.util.Arrays;

public class Test0240_搜索二维矩阵II {

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(
                new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}
                , 5
        ));
        System.out.println(new Solution().searchMatrix(
                new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}
                , 20
        ));
        System.out.println(new Solution().searchMatrix(
                new int[][]{{1, 1}}
                , 2
        ));
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int height = matrix.length;
            int width = matrix[0].length;
            // 从右上角开始判断
            int y = 0;
            int x = width - 1;
            boolean isFound;
            while (true) {
                if (matrix[y][x] == target) {
                    isFound = true;
                    break;
                }
                // 当前比目标小，则向下继续找（右边已排除）
                while (matrix[y][x] < target) {
                    y++;
                    if (y == height) {
                        return false;
                    }
                }
                // 当前比目标大，则向左继续找（上边已排除）
                while (matrix[y][x] > target) {
                    x--;
                    if (x < 0) {
                        return false;
                    }
                }
            }
            return isFound;
        }
    }

    static class Solution_二分 {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int[] row : matrix) {
                if (Arrays.binarySearch(row, target) >= 0) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution_暴力 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int height = matrix.length;
            int width = matrix[0].length;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix[y][x] == target) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
