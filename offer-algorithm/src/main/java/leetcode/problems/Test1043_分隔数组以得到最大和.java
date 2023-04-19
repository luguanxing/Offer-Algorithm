package leetcode.problems;

import java.util.Arrays;

public class Test1043_分隔数组以得到最大和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumAfterPartitioning(
                new int[]{1, 15, 7, 9, 2, 5, 10}, 3
        ));
        System.out.println(new Solution().maxSumAfterPartitioning(
                new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4
        ));
        System.out.println(new Solution().maxSumAfterPartitioning(
                new int[]{1}, 4
        ));
    }

    static class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int len = arr.length;
            // dp[i]表示到i的最大和
            int[] dp = new int[len + 1];
            dp[0] = arr[0];
            // dp[i] = max(dp[i-span-1] + spanMax*(span+1))，其中0<=span<=k-1, spanMax是arr[i-span,i]的最大值
            for (int i = 1; i < len; i++) {
                for (int span = 0; span <= k - 1; span++) {
                    int spanMax = Arrays.stream(arr, i - span, i + 1).max().getAsInt();
                    if (i - span - 1 < 0) {
                        dp[i] = Math.max(dp[i], spanMax * (span + 1));
                        break;
                    } else {
                        dp[i] = Math.max(dp[i], dp[i - span - 1] + spanMax * (span + 1));
                    }
                }
            }
            return dp[len - 1];
        }
    }

}
