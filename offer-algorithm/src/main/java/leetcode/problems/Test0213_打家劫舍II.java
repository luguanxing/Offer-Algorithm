package leetcode.problems;

import java.util.Arrays;

public class Test0213_打家劫舍II {

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2, 3, 2}));
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution().rob(new int[]{0, 0}));
    }

    static class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }
            int res1 = rob2(Arrays.copyOfRange(nums, 0, len - 1));
            int res2 = rob2(Arrays.copyOfRange(nums, 1, len));
            return Math.max(res1, res2);
        }

        int rob2(int[] nums) {
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }
            int[] rob = new int[len];
            rob[0] = nums[0];
            rob[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len; i++) {
                rob[i] = Math.max(rob[i - 2] + nums[i], rob[i - 1]);
            }
            return rob[len - 1];
        }

        int rob1(int[] nums) {
            int len = nums.length;
            int[] rob_i = new int[len];
            int[] norob_i = new int[len];
            rob_i[0] = nums[0];
            norob_i[0] = 0;
            rob_i[1] = nums[1];
            norob_i[1] = nums[0];
            for (int i = 2; i < len; i++) {
                rob_i[i] = Math.max(norob_i[i - 1] + nums[i], rob_i[i - 1]);
                norob_i[i] = Math.max(rob_i[i - 1], norob_i[i - 1]);
            }
            return Math.max(rob_i[len - 1], norob_i[len - 1]);
        }
    }

}
