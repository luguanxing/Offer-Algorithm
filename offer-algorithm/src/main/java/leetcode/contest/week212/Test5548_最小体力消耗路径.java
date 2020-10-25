package leetcode.contest.week212;

import java.util.Arrays;

public class Test5548_最小体力消耗路径 {

    public static void main(String[] args) {
//        System.out.println(new Solution().minimumEffortPath(new int[][]{
//                new int[]{1, 2, 2},
//                new int[]{3, 8, 2},
//                new int[]{5, 3, 5},
//        }));
//        System.out.println(new Solution().minimumEffortPath(new int[][]{
//                new int[]{1, 2, 3},
//                new int[]{3, 8, 4},
//                new int[]{5, 3, 5},
//        }));
//        System.out.println(new Solution().minimumEffortPath(new int[][]{
//                new int[]{1, 2, 1, 1, 1},
//                new int[]{1, 2, 1, 2, 1},
//                new int[]{1, 2, 1, 2, 1},
//                new int[]{1, 2, 1, 2, 1},
//                new int[]{1, 1, 1, 2, 1},
//        }));
//        System.out.println(new Solution().minimumEffortPath(new int[][]{
//                new int[]{3},
//        }));
        System.out.println(new Solution().minimumEffortPath(new int[][]{
                new int[]{8, 3, 2, 5, 2, 10, 7, 1, 8, 9},
                new int[]{1, 4, 9, 1, 10, 2, 4, 10, 3, 5},
                new int[]{4, 10, 10, 3, 6, 1, 3, 9, 8, 8},
                new int[]{4, 4, 6, 10, 10, 10, 2, 10, 8, 8},
                new int[]{9, 10, 2, 4, 1, 2, 2, 6, 5, 7},
                new int[]{2, 9, 2, 6, 1, 4, 7, 6, 10, 9},
                new int[]{8, 8, 2, 10, 8, 2, 3, 9, 5, 3},
                new int[]{2, 10, 9, 3, 5, 1, 7, 4, 5, 6},
                new int[]{2, 3, 9, 2, 5, 10, 2, 7, 1, 8},
                new int[]{9, 10, 4, 10, 7, 4, 9, 3, 1, 6},
        }));
    }

    static class Solution {
        public int minimumEffortPath(int[][] heights) {
            int[][] dp = new int[heights.length][heights[0].length];
            for (int y = 0; y < heights.length; y++) {
                for (int x = 0; x < heights[0].length; x++) {
                    dp[y][x] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = 0;
            for (int i = 0; i < 100; i++) {
                for (int y = 0; y < heights.length; y++) {
                    for (int x = 0; x < heights[0].length; x++) {
                        if (0 <= y - 1) {
                            dp[y][x] = Math.min(dp[y][x], Math.max(dp[y - 1][x], Math.abs(heights[y - 1][x] - heights[y][x])));
                        }
                        if (y + 1 < heights.length) {
                            dp[y][x] = Math.min(dp[y][x], Math.max(dp[y + 1][x], Math.abs(heights[y + 1][x] - heights[y][x])));
                        }
                        if (0 <= x - 1) {
                            dp[y][x] = Math.min(dp[y][x], Math.max(dp[y][x - 1], Math.abs(heights[y][x - 1] - heights[y][x])));
                        }
                        if (x + 1 < heights[0].length) {
                            dp[y][x] = Math.min(dp[y][x], Math.max(dp[y][x + 1], Math.abs(heights[y][x + 1] - heights[y][x])));
                        }
                    }
                }
            }
            return dp[heights.length - 1][heights[0].length - 1];
        }
    }

}
