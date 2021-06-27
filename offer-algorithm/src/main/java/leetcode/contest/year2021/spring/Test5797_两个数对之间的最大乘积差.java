package leetcode.contest.year2021.spring;

import java.util.Arrays;

public class Test5797_两个数对之间的最大乘积差 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProductDifference(new int[]{5, 6, 2, 7, 4}));
        System.out.println(new Solution().maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8}));
    }

    static class Solution {
        public int maxProductDifference(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
        }
    }

}
