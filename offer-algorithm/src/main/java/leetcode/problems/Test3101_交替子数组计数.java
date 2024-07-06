package leetcode.problems;

public class Test3101_交替子数组计数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countAlternatingSubarrays(new int[]{0, 1, 1, 1}));
        System.out.println(new Solution().countAlternatingSubarrays(new int[]{1, 0, 1, 0}));
    }

    static class Solution {
        public long countAlternatingSubarrays(int[] nums) {
            int len = nums.length;
            // dp[i]表示以第i个结尾的个数，也可优化不用数组直接累加
            long[] dp = new long[len];
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                if (nums[i] != nums[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
            }
            long res = 0;
            for (int i = 0; i < len; i++) {
                res += dp[i];
            }
            return res;
        }
    }

}
