package leetcode.leetcode.contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test1438_绝对差不超过限制的最长连续子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(new Solution().longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(new Solution().longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
        System.out.println(new Solution().longestSubarray(new int[]{4, 2, 3, 2, 4, 4, 2, 2}, 1));
        System.out.println(new Solution().longestSubarray(new int[]{4, 3, 2, 1}, 1));
        System.out.println(new Solution().longestSubarray(new int[]{7, 40, 10, 10, 40, 39, 96, 21, 54, 73, 33, 17, 2, 72, 5, 76, 28, 73, 59, 22, 100, 91, 80, 66, 5, 49, 26, 45, 13, 27, 74, 87, 56, 76, 25, 64, 14, 86, 50, 38, 65, 64, 3, 42, 79, 52, 37, 3, 21, 26, 42, 73, 18, 44, 55, 28, 35, 87}, 63));
    }

    static class Solution {
        public int longestSubarray(int[] nums, int limit) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 滑动窗口+排序队列
            int left = 0;
            int right = 0;
            int maxLen = 0;
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.naturalOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.reverseOrder());
            // 在滑动窗口滑动时判断边界，如果不超过限制可以加入，否则需要缩小窗口
            while (left <= right && right < nums.length) {
                int num = nums[right];
                int max = maxQueue.isEmpty() ? 0 : maxQueue.peek();
                int min = minQueue.isEmpty() ? 0 : minQueue.peek();
                if (maxQueue.isEmpty() || (Math.abs(max - num) <= limit && Math.abs(min - num) <= limit)) {
                    maxQueue.add(num);
                    minQueue.add(num);
                    right++;
                } else {
                    maxQueue.remove(nums[left]);
                    minQueue.remove(nums[left]);
                    left++;
                }
                maxLen = Math.max(maxLen, right - left);
            }
            return maxLen;
        }
    }

}
