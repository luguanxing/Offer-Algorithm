package leetcode.contest.week193;

import java.util.Arrays;

public class Test5436_一维数组的动态和 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(new Solution().runningSum(new int[]{3, 1, 2, 10, 1})));
    }

    static class Solution {
        public int[] runningSum(int[] nums) {
            if (nums == null) {
                return null;
            }
            int[] result = new int[nums.length];
            result[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                result[i] = result[i - 1] + nums[i];
            }
            return result;
        }
    }

}
