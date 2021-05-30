package leetcode.problems;

public class Test1074_元素和为目标值的子矩阵数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSubmatrixSumTarget(
                new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0
        ));
        System.out.println(new Solution().numSubmatrixSumTarget(
                new int[][]{{1, -1}, {-1, 1}}, 0
        ));
        System.out.println(new Solution().numSubmatrixSumTarget(
                new int[][]{{904}}, 0
        ));
    }

    static class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int height = matrix.length;
            int width = matrix[0].length;
            int[][] prefixSum = new int[height + 1][width + 1];
            int res = 0;
            for (int y = 1; y <= height; y++) {
                for (int x = 1; x <= width; x++) {
                    prefixSum[y][x] = prefixSum[y - 1][x] + prefixSum[y][x - 1] - prefixSum[y - 1][x - 1] + matrix[y - 1][x - 1];
                }
            }
            for (int y2 = 1; y2 <= height; y2++) {
                for (int x2 = 1; x2 <= width; x2++) {
                    for (int y1 = 1; y1 <= y2; y1++) {
                        for (int x1 = 1; x1 <= x2; x1++) {
                            // 从包括(y1,x1)在内的点到(y2,x2)组成的矩形和
                            if (prefixSum[y2][x2] - prefixSum[y2][x1 - 1] - prefixSum[y1 - 1][x2] + prefixSum[y1 - 1][x1 - 1] == target) {
                                res++;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }

}
