package leetcode.problems;

import java.util.Arrays;

public class Test2536_子矩阵元素加1 {

    public static void main(String[] args) {
        // n = 3, queries = [[1,1,2,2],[0,0,1,1]]
        int[][] solution1 = new Solution().rangeAddQueries(3, new int[][]{
                {1, 1, 2, 2},
                {0, 0, 1, 1}
        });
        for (int[] row : solution1) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        // n = 2, queries = [[0,0,1,1]]
        int[][] solution2 = new Solution().rangeAddQueries(2, new int[][]{
                {0, 0, 1, 1}
        });
        for (int[] row : solution2) {
            System.out.println(Arrays.toString(row));
        }
    }

    static class Solution {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            // 构建二维差分数组
            int[][] rowDiff = new int[n + 1][n + 1];
            for (int[] query : queries) {
                int r1 = query[0];
                int c1 = query[1];
                int r2 = query[2];
                int c2 = query[3];
                for (int r = r1; r <= r2; r++) {
                    rowDiff[r][c1] += 1;
                    rowDiff[r][c2 + 1] -= 1;
                }
            }
            // 计算结果
            int[][] res = new int[n][n];
            for (int r = 0; r < n; r++) {
                int curr = 0;
                for (int c = 0; c < n; c++) {
                    curr += rowDiff[r][c];
                    res[r][c] = curr;
                }
            }
            return res;
        }
    }

    static class Solution_TLE {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            int[][] res = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] query : queries) {
                        int r1 = query[0];
                        int c1 = query[1];
                        int r2 = query[2];
                        int c2 = query[3];
                        if (r >= r1 && r <= r2 && c >= c1 && c <= c2) {
                            res[r][c]++;
                        }
                    }
                }
            }
            return res;
        }
    }

}
