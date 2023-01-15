package leetcode.contest.week328;

import java.util.Arrays;

public class Test6292_子矩阵元素加1 {

    public static void main(String[] args) {
        int[][] res1 = new Solution().rangeAddQueries(3, new int[][]{{1, 1, 2, 2}, {0, 0, 1, 1}});
        for (int[] col1 : res1) {
            System.out.println(Arrays.toString(col1));
        }
        int[][] res2 = new Solution().rangeAddQueries(2, new int[][]{{0, 0, 1, 1}});
        for (int[] col2 : res2) {
            System.out.println(Arrays.toString(col2));
        }
    }

    static class Solution {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            int[][] matrix = new int[n][n];
            for (int[] query : queries) {
                int y1 = query[0];
                int x1 = query[1];
                int y2 = query[2];
                int x2 = query[3];
                for (int y = y1; y <= y2; y++) {
                    for (int x = x1; x <= x2; x++) {
                        matrix[y][x]++;
                    }
                }
            }
            return matrix;
        }
    }

}
