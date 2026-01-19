package leetcode.problems;

public class Test1292_元素和小于等于阈值的正方形的最大边长 {

    public static void main(String[] args) {
        // mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
        System.out.println(new Solution().maxSideLength(
                new int[][]{
                        {1, 1, 3, 2, 4, 3, 2},
                        {1, 1, 3, 2, 4, 3, 2},
                        {1, 1, 3, 2, 4, 3, 2}
                },
                4
        ));
        // mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
        System.out.println(new Solution().maxSideLength(
                new int[][]{
                        {2, 2, 2, 2, 2},
                        {2, 2, 2, 2, 2},
                        {2, 2, 2, 2, 2},
                        {2, 2, 2, 2, 2},
                        {2, 2, 2, 2, 2}
                },1
        ));
    }

    static class Solution {
        public int maxSideLength(int[][] mat, int threshold) {
            int height = mat.length;
            int width = mat[0].length;
            // prefixSum[i][j]表示以(0,0)为左上角，(i,j)为右下角的子矩阵的元素和
            int[][] prefixSum = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    prefixSum[i][j] = mat[i][j];
                    if (i > 0) {
                        prefixSum[i][j] += prefixSum[i - 1][j];
                    }
                    if (j > 0) {
                        prefixSum[i][j] += prefixSum[i][j - 1];
                    }
                    if (i > 0 && j > 0) {
                        prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                    }
                }
            }
            // 枚举找到最大正方形边长，也可以用二分法优化
            int maxSideLength = 0;
            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    // 以(r,c)为左上角，尝试不同边长的正方形
                    for (int sideLen = 1; sideLen <= Math.min(height - r, width - c); sideLen++) {
                        int brRow = r + sideLen - 1;
                        int brCol = c + sideLen - 1;
                        int squareSum = prefixSum[brRow][brCol];
                        if (r > 0) {
                            squareSum -= prefixSum[r - 1][brCol];
                        }
                        if (c > 0) {
                            squareSum -= prefixSum[brRow][c - 1];
                        }
                        if (r > 0 && c > 0) {
                            squareSum += prefixSum[r - 1][c - 1];
                        }
                        if (squareSum <= threshold) {
                            maxSideLength = Math.max(maxSideLength, sideLen);
                        } else {
                            // 如果当前边长的正方形和已经超过阈值，后续更大的边长也不可能满足条件，直接跳出
                            break;
                        }
                    }
                }
            }
            return maxSideLength;
        }
    }

}
