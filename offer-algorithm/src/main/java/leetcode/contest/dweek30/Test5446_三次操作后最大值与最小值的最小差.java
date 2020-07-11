package leetcode.contest.dweek30;

import java.util.Arrays;

public class Test5446_三次操作后最大值与最小值的最小差 {

    public static void main(String[] args) {
        System.out.println(new Solution().minDifference(new int[]{5, 3, 2, 4}));
        System.out.println(new Solution().minDifference(new int[]{1, 5, 0, 10, 14}));
        System.out.println(new Solution().minDifference(new int[]{6, 6, 0, 1, 1, 4, 6}));
        System.out.println(new Solution().minDifference(new int[]{1, 5, 6, 14, 15}));
        System.out.println(new Solution().minDifference(new int[]{82, 81, 95, 75, 20}));
    }

    static class Solution {
        public int minDifference(int[] nums) {
            // 先排序
            Arrays.sort(nums);
            // 去掉前后共三个找最小值
            if (nums.length <= 4) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= 4; i++) {
                min = Math.min(min, nums[nums.length - i] - nums[4 - i]);
            }
            return min;
        }
    }

}
