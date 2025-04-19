package leetcode.problems;

import java.util.Arrays;

public class Test2563_统计公平数对的数目 {

    public static void main(String[] args) {
        // nums = [0,1,7,4,4,5], lower = 3, upper = 6
        System.out.println(new Solution().countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
        // nums = [1,7,9,2,5], lower = 11, upper = 11
        System.out.println(new Solution().countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11));
    }

    static class Solution {
        public long countFairPairs(int[] nums, int lower, int upper) {
            int len = nums.length;
            Arrays.sort(nums);
            long res = 0;
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                int lIdx = leftBound(nums, lower - num, i + 1, len);
                int rIdx = rightBound(nums, upper - num, i + 1, len);
                if (lIdx >= 0 && rIdx >= 0 && rIdx >= lIdx) {
                    res += rIdx - lIdx + 1;
                }
            }
            return res;
        }

        int leftBound(int[] nums, int target, int l, int r) {
            int left = l;
            int right = r;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        int rightBound(int[] nums, int target, int l, int r) {
            int left = l;
            int right = r;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left - 1;
        }
    }

}
