package leetcode.contest.week196;

import java.util.Arrays;

public class Test5454_统计全1子矩形 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSubmat(
                new int[][]{
                        {1, 0, 1},
                        {1, 1, 0},
                        {1, 1, 0},
                }
        ));
        System.out.println(new Solution().numSubmat(
                new int[][]{
                        {0, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 1, 1, 0},
                }
        ));
        System.out.println(new Solution().numSubmat(
                new int[][]{
                        {1, 1, 1, 1, 1, 1},
                }
        ));
        System.out.println(new Solution().numSubmat(
                new int[][]{
                        {1, 0, 1},
                        {0, 1, 0},
                        {1, 0, 1},
                }
        ));
    }

    static class Solution {
        public int numSubmat(int[][] mat) {
            int height = mat.length;
            int width = mat[0].length;
            int[][] dp1 = new int[height][width];
            int[][] dp2 = new int[height][width];
            dp1[0][0] = mat[0][0];
            dp2[0][0] = mat[0][0];
            for (int x = 1; x < width; x++) {
                dp1[0][x] = mat[0][x] == 1 ? dp1[0][x - 1] + 1 : 0;
                dp2[0][x] = mat[0][x] == 1 ? dp2[0][x - 1] + 1 : 0;
            }
            for (int y = 1; y < height; y++) {
                dp1[y][0] = mat[y][0] == 1 ? dp1[y - 1][0] + 1 : 0;
                dp2[y][0] = mat[y][0] == 1 ? dp2[y - 1][0] + 1 : 0;
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    dp[y][x] = mat[y][x] == 1 ? dp[y][x - 1] + 1 : 0;
                }
            }
            for (int x = 1; x < width; x++) {
                for (int y = 1; y < height; y++) {
                    dp[y][x] = mat[y][x] == 1 ? dp[y - 1][x] + 1 : 0;
                }
            }
            int sum = 0;
            for (int[] nums : dp) {
                sum += Arrays.stream(nums).sum();
            }
            return sum;
        }
    }

}
