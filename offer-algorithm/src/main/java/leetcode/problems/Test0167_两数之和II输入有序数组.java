package leetcode.problems;

import java.util.Arrays;

public class Test0167_两数之和II输入有序数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            // 滑动窗口找目标和
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum < target) {
                    left++;
                } else if (target < sum) {
                    right--;
                } else {
                    break;
                }
            }
            return new int[]{left + 1, right + 1};
        }
    }

}
