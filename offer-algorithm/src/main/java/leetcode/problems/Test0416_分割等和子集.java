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
            if (nums == null) {
                return false;
            }
            // 先求和
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) {
                return false;
            }
            int half = sum / 2;
            // 转换为0-1背包问题，能否拿满容量为half的背包
            int[] v = new int[nums.length];
            int[] w = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                v[i] = nums[i];
                w[i] = nums[i];
            }
            return packeting(w, v, half) == half;
        }

        private int packeting(int[] w, int[] v, int c) {
            int len = w.length;
            // dp[i][j]表示从前i间物品选出总容量不超过j的最大价值
            int[][] dp = new int[len][c + 1];
            for (int i = 0; i <= c; i++) {
                dp[0][i] = (w[0] <= i) ? w[0] : 0;
            }
            for (int i = 1; i < len; i++) {
                for (int j = 0; j <= c; j++) {
                    // 不拿第i件物品
                    int noTakeI = dp[i - 1][j];
                    // 拿第i件物品
                    int takeI = 0;
                    if (w[i] <= j) {
                        takeI = dp[i - 1][j - w[i]] + v[i];
                    }
                    dp[i][j] = Math.max(noTakeI, takeI);
                }
            }
            return dp[len - 1][c];
        }
    }

}
