package leetcode;

import java.util.stream.Stream;

public class Test300_最长上升子序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(null));
        System.out.println(new Solution().lengthOfLIS(new int[]{}));
        System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 以dp[i]表示子序列必以nums[i]结尾时的最长子序列长度
            Integer[] dp = new Integer[nums.length];
            dp[0] = 1;
            // dp[i]=max(dp[1],dp[2]..dp[i-1])+1并且nums[k]<nums[i]
            for (int i = 1; i < nums.length; i++) {
                int max = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] = max + 1;
            }
            // 返回所有dp中的最大值
            return Stream.of(dp).max(Integer::compareTo).orElse(1);
        }
    }

}
