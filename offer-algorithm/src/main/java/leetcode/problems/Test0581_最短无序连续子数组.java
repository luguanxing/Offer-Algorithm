package leetcode.problems;

import java.util.Arrays;

public class Test0581_最短无序连续子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(
                new int[]{2, 6, 4, 8, 10, 9, 15}
        ));
        System.out.println(new Solution().findUnsortedSubarray(
                new int[]{1, 2, 3, 4}
        ));
        System.out.println(new Solution().findUnsortedSubarray(
                new int[]{1}
        ));
    }

    static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int len = nums.length;
            // 先排序
            int[] sortNums = Arrays.copyOf(nums, len);
            Arrays.sort(sortNums);
            // 找出和排序后结果不同的部分
            int left = 0;
            int right = len - 1;
            while (left < len && nums[left] == sortNums[left]) {
                left++;
            }
            while (right >= 0 && nums[right] == sortNums[right]) {
                right--;
            }
            if (right <= left) {
                return 0;
            }
            return right - left + 1;
        }
    }

}
