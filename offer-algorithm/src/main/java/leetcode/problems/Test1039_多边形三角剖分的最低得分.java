package leetcode.problems;

import java.util.Arrays;

public class Test1039_多边形三角剖分的最低得分 {

    public static void main(String[] args) {
        System.out.println(new Solution().minScoreTriangulation(new int[]{1, 2, 3}));
        System.out.println(new Solution().minScoreTriangulation(new int[]{3, 7, 4, 5}));
        System.out.println(new Solution().minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
    }

    static class Solution {
        private int[] v;
        private int[][] dp;

        public int minScoreTriangulation(int[] values) {
            int n = values.length;
            this.v = values;
            this.dp = new int[n][n];
            for (int[] m : dp) {
                Arrays.fill(m, -1);
            }
            return dfs(0, n - 1);
        }

        // dfs(m,n)表示从m点到n点之间划分后的最小分数，使用记忆化搜索
        private int dfs(int start, int end) {
            if (start + 1 == end) {
                return 0;
            }
            if (dp[start][end] != -1) {
                return dp[start][end];
            }
            // dp[i][j] = min(dp[start][i] + dp[i][end] + v[start]*v[i]*v[end])
            int min = Integer.MAX_VALUE;
            for (int i = start + 1; i < end; i++) {
                min = Math.min(min, dfs(start, i) + dfs(i, end) + v[start] * v[i] * v[end]);
            }
            dp[start][end] = min;
            return min;
        }
    }

}
