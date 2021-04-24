package leetcode.problems;

public class Test0377_组合总和Ⅳ {

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum4(
                new int[]{1, 2, 3}, 4
        ));
        System.out.println(new Solution().combinationSum4(
                new int[]{9}, 3
        ));
        System.out.println(new Solution().combinationSum4(
                new int[]{3, 4, 5, 6, 7, 8, 9, 10}, 10
        ));
    }

    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            // dp[i]表示nums数组凑出i的不同方法
            int[] dp = new int[target + 1];
            for (int num : nums) {
                if (num <= target) {
                    dp[num] = 1;
                }
            }
            // dp[i]=sum(dp[i-num])
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (i - num >= 0) {
                        dp[i] += dp[i - num];
                    }
                }
            }
            return dp[target];
        }
    }

}
