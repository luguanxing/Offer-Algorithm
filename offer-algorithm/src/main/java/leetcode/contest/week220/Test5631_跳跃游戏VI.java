package leetcode.contest.week220;

public class Test5631_跳跃游戏VI {

    public static void main(String[] args) {
        System.out.println(new Solution().maxResult(
                new int[]{1, -1, -2, 4, -7, 3}, 2
        ));
        System.out.println(new Solution().maxResult(
                new int[]{10, -5, -2, 4, 0, 3}, 3
        ));
        System.out.println(new Solution().maxResult(
                new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2
        ));
    }

    static class Solution {
        public int maxResult(int[] nums, int k) {
            int[] dp = new int[nums.length];
            int maxDpIndex = 0;
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int max = Integer.MIN_VALUE;
                if (i - k < maxDpIndex) {
                    max = dp[maxDpIndex];
                } else {
                    for (int j = Math.max(0, i - k); j <= i - 1; j++) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] = max + nums[i];
                // 保留最新的最大maxDpIndex，如果下次在范围中可以直接使用
                if (dp[i] > dp[maxDpIndex]) {
                    maxDpIndex = i;
                }
            }
            return dp[nums.length - 1];
        }
    }


}
