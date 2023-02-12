package leetcode.contest.week332;

import java.util.Arrays;

public class Test6355_统计公平数对的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countFairPairs(
                new int[]{0, 1, 7, 4, 4, 5}, 3, 6
        ));
        System.out.println(new Solution().countFairPairs(
                new int[]{1, 7, 9, 2, 5}, 11, 11
        ));
        System.out.println(new Solution().countFairPairs(
                new int[]{0, 0, 0, 0, 0, 0}, 0, 0
        ));
    }

    static class Solution {
        public long countFairPairs(int[] nums, int lower, int upper) {
            Arrays.sort(nums);
            int len = nums.length;
            long res = 0;
            for (int i = 0; i < len; i++) {
                // 找大于等于lower - nums[i]的最左边界
                int t = nums[i];
                int index1 = left_bound(nums, lower - t);
                // 找小于等于upper - l的最右边界
                int index2 = right_bound(nums, upper - t);
                if (index1 > index2) {
                    continue;
                }
                res += index2 - index1 + 1;
                if (index1 <= i && i < index2) {
                    res--;
                }
            }
            return res / 2;
        }

        int left_bound(int[] nums, int target) {
            int left = 0;
            int right = nums.length; // 注意

            while (left < right) { // 注意
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid; // 注意
                }
            }
            return left;
        }

        int right_bound(int[] nums, int target) {
            int left = 0, right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1; // 注意
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            return left - 1; // 注意
        }
    }

}
