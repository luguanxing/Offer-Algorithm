package leetcode.problems;

public class Test2369_检查数组是否存在有效划分 {

    public static void main(String[] args) {
        System.out.println(new Solution().validPartition(new int[]{4, 4, 4, 5, 6}));
        System.out.println(new Solution().validPartition(new int[]{1, 1, 1, 2}));
        System.out.println(new Solution().validPartition(new int[]{579611, 579611, 579611, 731172, 731172, 496074, 496074, 496074, 151416, 151416, 151416}));
    }

    static class Solution {
        public boolean validPartition(int[] nums) {
            int len = nums.length;
            boolean[] dp = new boolean[len];
            // 初始化状态
            dp[1] = nums[0] == nums[1];
            if (len > 2) {
                if (nums[0] == nums[1] && nums[1] == nums[2]) {
                    dp[2] = true;
                }
                if (nums[0] + 1 == nums[1] && nums[1] + 1 == nums[2]) {
                    dp[2] = true;
                }
            }
            // 动态规划计算
            for (int i = 2; i < len; i++) {
                if (dp[i - 2] && nums[i - 1] == nums[i]) {
                    dp[i] = true;
                }
                if (i - 3 >= 0 && dp[i - 3] && nums[i - 2] == nums[i - 1] && nums[i - 1] == nums[i]) {
                    dp[i] = true;
                }
                if (i - 3 >= 0 && dp[i - 3] && nums[i - 2] + 1 == nums[i - 1] && nums[i - 1] + 1 == nums[i]) {
                    dp[i] = true;
                }
            }
            return dp[len - 1];
        }
    }

}
