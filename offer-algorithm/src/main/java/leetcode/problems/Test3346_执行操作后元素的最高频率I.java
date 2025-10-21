package leetcode.problems;

import java.util.*;

public class Test3346_执行操作后元素的最高频率I {

    public static void main(String[] args) {
        // nums = [1,4,5], k = 1, numOperations = 2
        System.out.println(new Solution().maxFrequency(new int[]{1, 4, 5}, 1, 2));
        // nums = [5,11,20,20], k = 5, numOperations = 1
        System.out.println(new Solution().maxFrequency(new int[]{5, 11, 20, 20}, 5, 1));
        System.out.println(new Solution().maxFrequency(new int[]{1, 3}, 1, 2));
        System.out.println(new Solution().maxFrequency(new int[]{69, 12, 107, 102, 89}, 9, 5));
    }

    static class Solution {
        public int maxFrequency(int[] nums, int k, int numOperations) {
            // 先排序，加入平均数
            int res = 0;
            Arrays.sort(nums);
            // 然后试每个元素作为目标值
            int MAX = Arrays.stream(nums).max().getAsInt();
            int MIN = Arrays.stream(nums).min().getAsInt();
            for (int num = MIN; num <= MAX; num++) {
                int leftNumIdx = leftBound(nums, num);
                int rightNumIdx = rightBound(nums, num);
                int count = rightNumIdx - leftNumIdx + 1;
                // 计算nums范围内，有多少个数可以变成[leftNum, rightNum]范围内的数，最多不超过numOperations个
                int leftIndex = leftBound(nums, num - k);
                int rightIndex = rightBound(nums, num + k);
                int addableCount = rightIndex - rightNumIdx + leftNumIdx - leftIndex;
                count += Math.min(addableCount, numOperations);
                res = Math.max(res, count);
            }
            return res;
        }

        int leftBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
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

        int rightBound(int[] nums, int target) {
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
