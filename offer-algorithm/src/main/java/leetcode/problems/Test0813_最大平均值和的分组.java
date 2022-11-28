package leetcode.problems;

public class Test0813_最大平均值和的分组 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestSumOfAverages(
                new int[]{9, 1, 2, 3, 9}, 3
        ));
        System.out.println(new Solution().largestSumOfAverages(
                new int[]{1, 2, 3, 4, 5, 6, 7}, 4
        ));
    }

    static class Solution {
        public double largestSumOfAverages(int[] nums, int K) {
            int len = nums.length;
            // 假设dp[i][K]表示前i个数分k组的最大值
            // 假设sum[i]表示前i个数的和, sum[i]-sum[j]表示从j+1到i的和
            // dp[i][K] = max(dp[i][K], dp[j][K-1] + sum(j-i)/(i-j));
            double[][] dp = new double[len + 1][K + 1];
            double[] sum = new double[len + 1];
            for (int i = 1; i <= len; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
                dp[i][1] = sum[i] / i;
            }
            for (int i = 1; i <= len; i++) {
                for (int k = 2; k <= K; k++) {
                    for (int j = 0; j < i; j++) {
                        dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (sum[i] - sum[j]) / (i - j));
                    }
                }
            }
            return dp[len][K];
        }
    }

}
