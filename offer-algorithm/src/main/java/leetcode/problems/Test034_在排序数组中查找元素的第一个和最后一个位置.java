package leetcode.problems;

import java.util.Arrays;

public class Test034_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(
                new int[]{5, 7, 7, 8, 8, 10}, 8
        )));
        System.out.println(Arrays.toString(new Solution().searchRange(
                new int[]{5, 7, 7, 8, 8, 10}, 6
        )));
        System.out.println(Arrays.toString(new Solution().searchRange(
                new int[]{1, 1, 2}, 1
        )));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int mid = Arrays.binarySearch(nums, 0, nums.length, target);
            if (mid < 0) {
                return new int[]{-1, -1};
            }
            int[] res = new int[2];
            int left = mid, right = mid + 1;
            while (Arrays.binarySearch(nums, 0, left, target) >= 0) {
                left = Arrays.binarySearch(nums, 0, left, target);
            }
            while (Arrays.binarySearch(nums, right, nums.length, target) >= 0) {
                right = Arrays.binarySearch(nums, right, nums.length, target) + 1;
            }
            res[0] = left;
            res[1] = right - 1;
            return res;
        }
    }

}
