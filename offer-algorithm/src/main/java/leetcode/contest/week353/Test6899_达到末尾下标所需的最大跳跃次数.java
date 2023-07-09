package leetcode.contest.week353;

import java.util.Arrays;

public class Test6899_达到末尾下标所需的最大跳跃次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2));
        System.out.println(new Solution().maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 3));
        System.out.println(new Solution().maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 0));
        System.out.println(new Solution().maximumJumps(new int[]{0, 2, 1, 3}, 1));
    }

    static class Solution {
        public int maximumJumps(int[] nums, int target) {
            int len = nums.length;
            int[] dp = new int[len];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] != -1 && Math.abs(nums[i] - nums[j]) <= target) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[len - 1];
        }
    }

}
