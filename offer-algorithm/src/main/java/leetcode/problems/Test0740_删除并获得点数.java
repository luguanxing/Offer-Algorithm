package leetcode.problems;

import java.util.Arrays;

public class Test0740_删除并获得点数 {

    public static void main(String[] args) {
        System.out.println(new Solution().deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(new Solution().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }

    static class Solution {
        public int deleteAndEarn(int[] nums) {
            int MAX = 10005;
            int[] cntMap = new int[MAX];
            int[] score = new int[MAX];
            for (int num : nums) {
                cntMap[num]++;
            }
            for (int i = 1; i < MAX; i++) {
                score[i] = i * cntMap[i];
            }
            // 打家劫舍
            int[] dp = new int[MAX];
            dp[1] = score[1];
            for (int i = 2; i < MAX; i++) {
                int no = dp[i - 1];
                int yes = dp[i - 2] + score[i];
                dp[i] = Math.max(no, yes);
            }
            return Arrays.stream(dp).max().orElse(0);
        }
    }

}
