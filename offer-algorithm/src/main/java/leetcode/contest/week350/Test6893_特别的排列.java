package leetcode.contest.week350;

import java.util.Arrays;

public class Test6893_特别的排列 {

    public static void main(String[] args) {
        System.out.println(new Solution().specialPerm(new int[]{2, 3, 6}));
        System.out.println(new Solution().specialPerm(new int[]{1, 4, 3}));
    }

    static class Solution {
        public int specialPerm(int[] nums) {
            int MOD = 1000000007;
            Arrays.sort(nums);
            int len = nums.length;
            // 判断能否相邻
            boolean[][] adj = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                        adj[i][j] = true;
                    }
                }
            }
            // 动态规划，dp[mask][i]表示以mask状态和以i结尾的答案数
            int[][] dp = new int[1 << len][len];
            for (int i = 0; i < len; i++) {
                dp[1 << i][i] = 1;
            }
            for (int mask = 1; mask < (1 << len); mask++) {
                for (int x = 0; x < len; x++) {
                    if ((mask & (1 << x)) > 0) {
                        for (int y = 0; y < len; y++) {
                            if ((mask & (1 << y)) > 0 && adj[x][y]) {
                                dp[mask][x] += dp[mask ^ (1 << x)][y];
                                dp[mask][x] %= MOD;
                            }
                        }
                    }
                }
            }
            // 计算结果
            int ans = 0;
            for (int i = 0; i < len; i++) {
                ans += dp[(1 << len) - 1][i];
                ans %= MOD;
            }
            return ans;
        }
    }

}
