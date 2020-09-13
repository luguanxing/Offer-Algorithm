package leetcode.problems;

import java.util.Arrays;

public class Test0416_分割等和子集 {

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new Solution().canPartition(new int[]{1, 1, 1, 1}));
        System.out.println(new Solution().canPartition(new int[]{3, 3, 3, 4, 5}));
    }

    static class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            return sum - packeting(nums, nums, sum / 2) == sum / 2;
        }

        private int packeting(int[] w, int[] v, int c) {
            // dp[i][j]表示用前i个物品装j空间能得到的最大价值
            int[][] dp = new int[w.length + 1][c + 1];
            for (int i = 1; i <= w.length; i++) {
                for (int j = 1; j <= c; j++) {
                    int weight = w[i - 1];
                    if (j < weight) {
                        // 当前空间装不下i物品的情况
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 当前空间能装下，考虑放或不放物品i
                        int withI = dp[i - 1][j - weight] + v[i - 1];
                        int withoutI = dp[i - 1][j];
                        dp[i][j] = Math.max(withI, withoutI);
                    }
                }
            }
            return dp[w.length][c];
        }
    }

}
