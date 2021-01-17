package leetcode.contest.week224;

import java.util.Arrays;

public class Test5655_重新排列后的最大子矩阵 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestSubmatrix(new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 1}
        }));
        System.out.println(new Solution().largestSubmatrix(new int[][]{
                {1, 0, 1, 0, 1},
        }));
        System.out.println(new Solution().largestSubmatrix(new int[][]{
                {1, 1, 0},
                {1, 0, 1},
        }));
    }

    static class Solution {
        public int largestSubmatrix(int[][] matrix) {
            int height = matrix.length;
            int width = matrix[0].length;
            // 先计算上面连续1的个数
            for (int y = 1; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    matrix[y][x] += matrix[y][x] == 1 ? matrix[y - 1][x] : 0;
                }
            }
            // 每列先按连续1个数排序，降维后，从右到左计算最大面积
            int res = 0;
            for (int y = 0; y < height; y++) {
                Arrays.sort(matrix[y]);
                for (int x = width - 1; x >= 0; x--) {
                    int h = matrix[y][x];
                    int w = width - x;
                    res = Math.max(res, w * h);
                }
            }
            return res;
        }
    }

}
