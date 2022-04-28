package leetcode.problems;

import java.util.Arrays;

public class Test0905_按奇偶排序数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{0})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{0, 2})));
    }

    static class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                while (left < nums.length && nums[left] % 2 == 0) {
                    left++;
                }
                while (right >= 0 && nums[right] % 2 == 1) {
                    right--;
                }
                if (left < right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
            }
            return nums;
        }
    }

}
