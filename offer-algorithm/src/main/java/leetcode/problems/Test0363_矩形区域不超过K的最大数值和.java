package leetcode.problems;

public class Test0363_矩形区域不超过K的最大数值和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumSubmatrix(
                new int[][]{{1, 0, 1}, {0, -2, 3}}, 2
        ));
        System.out.println(new Solution().maxSumSubmatrix(
                new int[][]{{2, 2, -1}}, 3
        ));
        System.out.println(new Solution().maxSumSubmatrix(
                new int[][]{{2, 2, -1}}, 0
        ));
    }

    static class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int height = matrix.length;
            int width = matrix[0].length;
            int res = Integer.MIN_VALUE;
            // 计算求和矩阵
            int[][] sum = new int[height][width];
            sum[0][0] = matrix[0][0];
            for (int x = 1; x < width; x++) {
                sum[0][x] += sum[0][x - 1] + matrix[0][x];
            }
            for (int y = 1; y < height; y++) {
                sum[y][0] += sum[y - 1][0] + matrix[y][0];
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    sum[y][x] += sum[y][x - 1] + sum[y - 1][x] - sum[y - 1][x - 1] + matrix[y][x];
                }
            }
            // 判断是否存在矩形
            for (int y1 = 0; y1 < height; y1++) {
                for (int x1 = 0; x1 < width; x1++) {
                    for (int y2 = y1; y2 < height; y2++) {
                        for (int x2 = x1; x2 < width; x2++) {
                            int leftSum = x1 == 0 ? 0 : sum[y2][x1 - 1];
                            int upSum = y1 == 0 ? 0 : sum[y1 - 1][x2];
                            int leftUpSum = (y1 == 0 || x1 == 0) ? 0 : sum[y1 - 1][x1 - 1];
                            int cur = sum[y2][x2] - leftSum - upSum + leftUpSum;
                            if (cur <= k) {
                                res = Math.max(res, cur);
                            }
                        }
                    }
                }
            }
            return res;
        }
    }

}
