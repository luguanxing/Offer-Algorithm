package leetcode.contest.week341;

import java.util.Arrays;

public class Test6376_一最多的行 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().rowAndMaximumOnes(new int[][]{
                {0, 1}, {1, 0}
        })));
        System.out.println(Arrays.toString(new Solution().rowAndMaximumOnes(new int[][]{
                {0, 0, 0}, {0, 1, 1}
        })));
        System.out.println(Arrays.toString(new Solution().rowAndMaximumOnes(new int[][]{
                {0, 0}, {1, 1}, {0, 0}
        })));
    }

    static class Solution {
        public int[] rowAndMaximumOnes(int[][] mat) {
            int maxRow = 0;
            int maxCnt = 0;
            for (int row = 0; row < mat.length; row++) {
                int cnt = Arrays.stream(mat[row]).sum();
                if (cnt > maxCnt) {
                    maxRow = row;
                    maxCnt = cnt;
                }
            }
            return new int[]{maxRow, maxCnt};
        }
    }

}
