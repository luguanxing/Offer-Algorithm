package leetcode.contest.week310;

import java.util.Arrays;

public class Test6206_最长递增子序列II {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3));
        System.out.println(new Solution().lengthOfLIS(new int[]{7, 4, 5, 1, 8, 12, 4, 7}, 5));
        System.out.println(new Solution().lengthOfLIS(new int[]{1, 5}, 1));
        System.out.println(new Solution().lengthOfLIS(new int[]{5, 4, 7, 4, 10, 17, 14}, 7));
    }

    static class Solution {
        public int lengthOfLIS(int[] nums, int k) {
            int len = nums.length;
            // dp[i]表示以第i个数据结尾的最长子序列长度
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                for (int j = 0; j < i; j++) {
                    int lastNum = nums[j];
                    int lastCnt = dp[j];
                    if (num > lastNum && num - lastNum <= k) {
                        dp[i] = Math.max(dp[i], lastCnt + 1);
                    }
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }

}
