package offer;

public class LCP07_传递信息 {

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(
                5,
                new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}},
                3
        ));
        System.out.println(new Solution().numWays(
                3,
                new int[][]{{0, 2}, {2, 1}},
                2
        ));
    }

    static class Solution {
        public int numWays(int n, int[][] relation, int k) {
            boolean[][] map = new boolean[n][n];
            for (int[] r : relation) {
                int src = r[0];
                int dst = r[1];
                map[src][dst] = true;
            }
            // dp[i][j]表示第i轮后能到第j人的方法数
            // dp[i][j] = 在i-1轮所有能从x到j的dp[i-1][x]求和
            int[][] dp = new int[k + 1][n];
            dp[0][0] = 1;
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int x = 0; x < n; x++) {
                        if (map[x][j]) {
                            dp[i][j] += dp[i - 1][x];
                        }
                    }
                }
            }
            return dp[k][n - 1];
        }
    }

}
