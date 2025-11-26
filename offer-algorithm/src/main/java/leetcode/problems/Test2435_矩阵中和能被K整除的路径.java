package leetcode.problems;

public class Test2435_矩阵中和能被K整除的路径 {

    public static void main(String[] args) {
        // grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
        System.out.println(new Solution().numberOfPaths(
                new int[][]{
                        {5, 2, 4},
                        {3, 0, 5},
                        {0, 7, 2}
                },
                3
        ));
        // grid = [[0,0]], k = 5
        System.out.println(new Solution().numberOfPaths(
                new int[][]{
                        {0, 0}
                },
                5
        ));
        // grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]], k = 1
        System.out.println(new Solution().numberOfPaths(
                new int[][]{
                        {7, 3, 4, 9},
                        {2, 3, 6, 2},
                        {2, 3, 7, 0}
                },
                1
        ));
    }

    static class Solution {
        public int numberOfPaths(int[][] grid, int k) {
            int MOD = (int) 1e9 + 7;
            int rowCnt = grid.length;
            int colCnt = grid[0].length;
            // dp[r][i][j]表示到达(i,j)位置时，路径和对k取模等于r的路径数量
            int[][][] dp = new int[k][rowCnt][colCnt];
            dp[grid[0][0] % k][0][0] = 1;
            for (int row = 1; row < rowCnt; row++) {
                for (int lastMod = 0; lastMod < k; lastMod++) {
                    int mod = (lastMod + grid[row][0]) % k;
                    dp[mod][row][0] += dp[lastMod][row - 1][0];
                    dp[mod][row][0] %= MOD;
                }
            }
            for (int col = 1; col < colCnt; col++) {
                for (int lastMod = 0; lastMod < k; lastMod++) {
                    int mod = (lastMod + grid[0][col]) % k;
                    dp[mod][0][col] += dp[lastMod][0][col - 1];
                    dp[mod][0][col] %= MOD;
                }
            }
            // dp[mod][row][col] = dp[lastMod][row-1][col] + dp[lastMod][row][col-1]
            for (int row = 1; row < rowCnt; row++) {
                for (int col = 1; col < colCnt; col++) {
                    for (int lastMod = 0; lastMod < k; lastMod++) {
                        int mod = (lastMod + grid[row][col]) % k;
                        dp[mod][row][col] += dp[lastMod][row - 1][col];
                        dp[mod][row][col] %= MOD;
                        dp[mod][row][col] += dp[lastMod][row][col - 1];
                        dp[mod][row][col] %= MOD;
                    }
                }
            }
            return dp[0][rowCnt - 1][colCnt - 1];
        }
    }

}
