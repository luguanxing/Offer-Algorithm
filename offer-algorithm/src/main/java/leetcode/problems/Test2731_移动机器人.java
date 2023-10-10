package leetcode.problems;

import java.util.Arrays;

public class Test2731_移动机器人 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumDistance(new int[]{-2, 0, 2}, "RLL", 3));
        System.out.println(new Solution().sumDistance(new int[]{1, 0}, "RL", 2));
    }

    static class Solution {
        public int sumDistance(int[] nums, String s, int d) {
            int MOD = (int) (1E9 + 7);
            int len = nums.length;
            char[] directions = s.toCharArray();
            for (int i = 0; i < len; i++) {
                if (directions[i] == 'R') {
                    nums[i] += d;
                } else {
                    nums[i] -= d;
                }
            }
            Arrays.sort(nums);
            // 第i个数减与前面所有数的差=nums[i]*n - sum(0,i-1)
            long sum = 0;
            long prefix = nums[0];
            for (int i = 1; i < len; i++) {
                sum += (long) (i) * nums[i] - prefix;
                sum %= MOD;
                prefix += nums[i];
                prefix %= MOD;
            }
            return (int) sum;
        }
    }

}
