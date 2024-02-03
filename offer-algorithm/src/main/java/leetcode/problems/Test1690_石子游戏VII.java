package leetcode.problems;

import java.util.Arrays;

public class Test1690_石子游戏VII {

    public static void main(String[] args) {
        System.out.println(new Solution().stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        System.out.println(new Solution().stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
    }

    static class Solution {
        int[] sum;
        int[][] dp;

        public int stoneGameVII(int[] stones) {
            int len = stones.length;
            sum = new int[len + 1];
            dp = new int[len][len];
            for (int i = 1; i <= len; i++) {
                sum[i] = sum[i - 1] + stones[i - 1];
            }
            // dfs + 记忆化搜索
            return dfs(0, len - 1);
        }

        private int dfs(int left, int right) {
            if (left > right) {
                return 0;
            }
            if (dp[left][right] != 0) {
                return dp[left][right];
            }
            // 先手有两种选择，取left或者取right，都需要使自己最大化
            int diff1 = sum[right + 1] - sum[left + 1] - dfs(left + 1, right);
            int diff2 = sum[right] - sum[left] - dfs(left, right - 1);
            int res = Math.max(diff1, diff2);
            dp[left][right] = res;
            return res;
        }
    }

}
