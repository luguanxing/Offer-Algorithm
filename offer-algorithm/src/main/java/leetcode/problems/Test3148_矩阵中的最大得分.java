package leetcode.problems;

import java.util.*;

public class Test3148_矩阵中的最大得分 {

    public static void main(String[] args) {
        // grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]
        System.out.println(new Solution().maxScore(Arrays.asList(
                Arrays.asList(9, 5, 7, 3),
                Arrays.asList(8, 9, 6, 1),
                Arrays.asList(6, 7, 14, 3),
                Arrays.asList(2, 5, 3, 1)
        )));
        // grid = [[4,3,2],[3,2,1]]
        System.out.println(new Solution().maxScore(Arrays.asList(
                Arrays.asList(4, 3, 2),
                Arrays.asList(3, 2, 1)
        )));
        // grid = [[6,5,1],[5,7,9],[6,7,4],[6,10,5]]
        System.out.println(new Solution().maxScore(Arrays.asList(
                Arrays.asList(6, 5, 1),
                Arrays.asList(5, 7, 9),
                Arrays.asList(6, 7, 4),
                Arrays.asList(6, 10, 5)
        )));
    }

    static class Solution {
        public int maxScore(List<List<Integer>> grid) {
            int height = grid.size();
            int width = grid.get(0).size();
            // dp表示每个位置的最大分数，只可能从左边或上边来
            int[][] dp = new int[height][width];
            for (int[] row : dp) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
            int max = Integer.MIN_VALUE;
            for (int x = 1; x < width; x++) {
                for (int i = 0; i < x; i++) {
                    dp[0][x] = Math.max(dp[0][x], grid.get(0).get(x) - grid.get(0).get(i));
                }
                max = Math.max(max, dp[0][x]);
            }
            for (int y = 1; y < height; y++) {
                for (int i = 0; i < y; i++) {
                    dp[y][0] = Math.max(dp[y][0], grid.get(y).get(0) - grid.get(i).get(0));
                }
                max = Math.max(max, dp[y][0]);
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    // 这一步不需要遍历左边和上边的所有位置
                    // 直接用可选的继承值dp[y][x-1]和dp[y-1][x] + 与左边或上边的差值即可
                    // 因为继承值已经比较过上面和左边的了（已包含了最大的增量），可以直接使用
                    dp[y][x] = Math.max(dp[y][x], Math.max(dp[y][x - 1], 0) + grid.get(y).get(x) - grid.get(y).get(x - 1));
                    dp[y][x] = Math.max(dp[y][x], Math.max(dp[y - 1][x], 0) + grid.get(y).get(x) - grid.get(y - 1).get(x));
                    max = Math.max(max, dp[y][x]);
                }
            }
            return max;
        }
    }

    static class Solution_TLE {
        public int maxScore(List<List<Integer>> grid) {
            int height = grid.size();
            int width = grid.get(0).size();
            // dp表示每个位置的最大分数，只可能从左边或上边来
            int[][] dp = new int[height][width];
            for (int[] row : dp) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
            int max = Integer.MIN_VALUE;
            for (int x = 1; x < width; x++) {
                for (int i = 0; i < x; i++) {
                    dp[0][x] = Math.max(dp[0][x], grid.get(0).get(x) - grid.get(0).get(i));
                }
                max = Math.max(max, dp[0][x]);
            }
            for (int y = 1; y < height; y++) {
                for (int i = 0; i < y; i++) {
                    dp[y][0] = Math.max(dp[y][0], grid.get(y).get(0) - grid.get(i).get(0));
                }
                max = Math.max(max, dp[y][0]);
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    for (int i = 0; i < x; i++) {
                        dp[y][x] = Math.max(dp[y][x], Math.max(dp[y][i], 0) + grid.get(y).get(x) - grid.get(y).get(i));
                    }
                    for (int i = 0; i < y; i++) {
                        dp[y][x] = Math.max(dp[y][x], Math.max(dp[i][x], 0) + grid.get(y).get(x) - grid.get(i).get(x));
                    }
                    max = Math.max(max, dp[y][x]);
                }
            }
            return max;
        }
    }

}
