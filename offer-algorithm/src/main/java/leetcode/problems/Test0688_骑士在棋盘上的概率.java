package leetcode.problems;

import java.util.Arrays;

public class Test0688_骑士在棋盘上的概率 {

    public static void main(String[] args) {
        System.out.println(new Solution().knightProbability(3, 1, 0, 0));
        System.out.println(new Solution().knightProbability(3, 2, 0, 0));
        System.out.println(new Solution().knightProbability(1, 0, 0, 0));
    }

    static class Solution {
        public double knightProbability(int n, int k, int row, int column) {
            int[][] moves = new int[][]{{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

            // dp[k][y][x]表示出发走k步后棋在该(y,x)点的概率
            double[][][] dp = new double[k + 1][n][n];
            dp[0][row][column] = 1;

            // dp[k][y][x] = sum(1/8 * dp[k-1][y+moveY][x+moveX])，只可能是从八个方向过来
            for (int step = 1; step <= k; step++) {
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < n; x++) {
                        for (int[] move : moves) {
                            int lastY = y + move[0];
                            int lastX = x + move[1];
                            if (0 <= lastX && lastX < n && 0 <= lastY && lastY < n) {
                                dp[step][y][x] += 0.125 * dp[step - 1][lastY][lastX];
                            }
                        }
                    }
                }
            }

            // 计算第k步后场上所有可能性之和
            double res = 0;
            for (double[] dpRow : dp[k]) {
                res += Arrays.stream(dpRow).sum();
            }
            return res;
        }
    }

}
