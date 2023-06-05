package leetcode.problems;

import java.util.Arrays;

public class Test2460_对数组执行操作 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{0, 1})));
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{5, 119, 119, 119, 119, 218, 0, 0, 0, 0})));
    }

    static class Solution {
        public int[] applyOperations(int[] nums) {
            int[] tmp = new int[nums.length];
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1] && nums[i] != 0) {
                    nums[i] *= 2;
                    nums[i + 1] = 0;
                }
            }
            int idx = 0;
            for (int num : nums) {
                if (num != 0) {
                    tmp[idx++] = num;
                }
            }
            return tmp;
        }
    }

}
