package leetcode.contest.week397;

import java.util.*;

public class Test100281_矩阵中的最大得分 {

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
        // [[1,8,9,8],[7,9,6,9],[9,3,8,2],[2,8,4,10],[1,2,5,5]]
        System.out.println(new Solution().maxScore(Arrays.asList(
                Arrays.asList(1, 8, 9, 8),
                Arrays.asList(7, 9, 6, 9),
                Arrays.asList(9, 3, 8, 2),
                Arrays.asList(2, 8, 4, 10),
                Arrays.asList(1, 2, 5, 5)
        )));
        // [[6,5,1],[5,7,9],[6,7,4],[6,10,5]]
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
            int[][] dp = new int[height][width];
            for (int[] row : dp) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
            TreeSet<Integer>[] xSets = new TreeSet[width];
            TreeSet<Integer>[] ySets = new TreeSet[height];
            for (int i = 0; i < width; i++) {
                xSets[i] = new TreeSet<>();
            }
            for (int i = 0; i < height; i++) {
                ySets[i] = new TreeSet<>();
            }
            for (int x = 1; x < width; x++) {
                for (int xx = x - 1; xx >= 0; xx--) {
                    dp[0][x] = Math.max(dp[0][x], grid.get(0).get(x) - grid.get(0).get(xx));
                }
                xSets[x].add(Math.max(0, dp[0][x]) - grid.get(0).get(x));
            }
            for (int y = 1; y < height; y++) {
                for (int yy = y - 1; yy >= 0; yy--) {
                    dp[y][0] = Math.max(dp[y][0], grid.get(y).get(0) - grid.get(yy).get(0));
                }
                ySets[y].add(Math.max(0, dp[y][0]) - grid.get(y).get(0));
            }
            int max = Integer.MIN_VALUE;
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    // 检查上方值
                    dp[y][x] = Math.max(dp[y][x], xSets[x].last() + grid.get(y).get(x));
                    // 检查左方值
                    dp[y][x] = Math.max(dp[y][x], ySets[y].last() + grid.get(y).get(x));
                    // 更新
                    xSets[x].add(Math.max(0, dp[y][x]) - grid.get(y).get(x));
                    ySets[y].add(Math.max(0, dp[y][x]) - grid.get(y).get(x));
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max;
        }
    }

}
