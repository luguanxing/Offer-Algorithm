package leetcode.problems;

import java.util.Arrays;

public class Test3634_使数组平衡的最少移除数目 {

    public static void main(String[] args) {
        // nums = [2,1,5], k = 2
        System.out.println(new Solution().minRemoval(new int[]{2, 1, 5}, 2));
        // nums = [1,6,2,9], k = 3
        System.out.println(new Solution().minRemoval(new int[]{1, 6, 2, 9}, 3));
        // nums = [4,6], k = 2
        System.out.println(new Solution().minRemoval(new int[]{4, 6}, 2));
    }

    static class Solution {
        public int minRemoval(int[] nums, int k) {
            Arrays.sort(nums);
            int len = nums.length;
            // 双指针查找找出最长窗口
            int maxWindowLen = 0;
            int l = 0;
            int r = 0;
            while (l < len && r < len) {
                if ((long) nums[r] <= (long) nums[l] * k) {
                    maxWindowLen = Math.max(maxWindowLen, r - l + 1);
                    r++;
                } else {
                    l++;
                }
            }
            return len - maxWindowLen;
        }
    }

    static class Solution_滑动窗口 {
        public int minRemoval(int[] nums, int k) {
            Arrays.sort(nums);
            int len = nums.length;
            // 二分查找找出最长窗口
            int maxWindowLen = 0;
            for (int startIdx = 0; startIdx < len; startIdx++) {
                int num = nums[startIdx];
                int endIdx = rightBound(nums, (long) num * k);
                maxWindowLen = Math.max(maxWindowLen, endIdx - startIdx + 1);
            }
            return len - maxWindowLen;
        }

        int rightBound(int[] nums, long target) {
            int left = 0, right = nums.length;

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
