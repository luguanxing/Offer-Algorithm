package leetcode.problems;

import java.util.Arrays;

public class Test1727_重新排列后的最大子矩阵 {

    public static void main(String[] args) {
        // matrix = [[0,0,1],[1,1,1],[1,0,1]]
        System.out.println(new Solution().largestSubmatrix(new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 1}
        }));
        // matrix = [[1,0,1,0,1]]
        System.out.println(new Solution().largestSubmatrix(new int[][]{
                {1, 0, 1, 0, 1}
        }));
        // matrix = [[1,1,0],[1,0,1]]
        System.out.println(new Solution().largestSubmatrix(new int[][]{
                {1, 1, 0},
                {1, 0, 1}
        }));
        // matrix = [[0,0],[0,0]]
        System.out.println(new Solution().largestSubmatrix(new int[][]{
                {0, 0},
                {0, 0}
        }));
    }

    static class Solution {
        public int largestSubmatrix(int[][] matrix) {
            int height = matrix.length;
            int width = matrix[0].length;
            int maxArea = 0;
            // 统计每行上方累积1的数量
            int[][] upAcc1Counts = new int[height][width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix[y][x] == 1) {
                        upAcc1Counts[y][x] = (y - 1 >= 0 ? upAcc1Counts[y - 1][x] : 0) + 1;
                    }
                }
            }
            for (int[] upAcc1Count : upAcc1Counts) {
                // 排序累积1数量，枚举计算最大矩形
                Arrays.sort(upAcc1Count);
                int h = upAcc1Count[width - 1];
                maxArea = Math.max(maxArea, h);
                for (int w = 2; width - w >= 0; w++) {
                    h = Math.min(h, upAcc1Count[width - w]);
                    maxArea = Math.max(maxArea, w * h);
                }
            }
            return maxArea;
        }
    }

}
