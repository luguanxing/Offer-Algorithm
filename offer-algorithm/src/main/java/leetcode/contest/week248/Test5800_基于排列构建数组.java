package leetcode.contest.week248;

import java.util.Arrays;

public class Test5800_基于排列构建数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().buildArray(new int[]{0, 2, 1, 5, 3, 4})));
        System.out.println(Arrays.toString(new Solution().buildArray(new int[]{5, 0, 1, 2, 3, 4})));
    }

    static class Solution {
        public int[] buildArray(int[] nums) {
            int len = nums.length;
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = nums[nums[i]];
            }
            return res;
        }
    }

}
