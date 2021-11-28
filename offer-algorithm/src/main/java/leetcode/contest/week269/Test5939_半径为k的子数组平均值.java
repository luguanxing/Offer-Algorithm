package leetcode.contest.week269;

import java.util.Arrays;

public class Test5939_半径为k的子数组平均值 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3)));
        System.out.println(Arrays.toString(new Solution().getAverages(new int[]{100000}, 0)));
        System.out.println(Arrays.toString(new Solution().getAverages(new int[]{8}, 100000)));
        System.out.println(Arrays.toString(new Solution().getAverages(new int[]{1, 1, 1}, 1)));
        System.out.println(Arrays.toString(new Solution().getAverages(new int[]{1, 5, 1}, 1)));
    }

    static class Solution {
        public int[] getAverages(int[] nums, int k) {
            int[] res = new int[nums.length];
            long sum = 0;
            for (int i = 0; i < Math.min(nums.length, k); i++) {
                res[i] = -1;
            }
            for (int i = nums.length - 1; i > Math.max(nums.length - 1 - k, 0); i--) {
                res[i] = -1;
            }
            for (int i = 0; i < Math.min(2 * k + 1, nums.length); i++) {
                sum += nums[i];
            }
            for (int i = k; i <= nums.length - 1 - k; i++) {
                res[i] = (int) (sum / (2 * k + 1));
                if (i == nums.length - 1 - k) {
                    break;
                }
                sum -= nums[i - k];
                sum += nums[i + k + 1];
            }
            return res;
        }
    }

}
