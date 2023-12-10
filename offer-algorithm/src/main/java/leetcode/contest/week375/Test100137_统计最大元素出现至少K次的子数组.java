package leetcode.contest.week375;

import java.util.*;

public class Test100137_统计最大元素出现至少K次的子数组 {

    public static void main(String[] args) {
        // nums = [1,3,2,3,3], k = 2
        System.out.println(new Solution().countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
        // nums = [1,4,2,1], k = 3
        System.out.println(new Solution().countSubarrays(new int[]{1, 4, 2, 1}, 3));
    }

    static class Solution {
        public long countSubarrays(int[] nums, int k) {
            int maxElement = Arrays.stream(nums).max().getAsInt();
            long count = 0;
            int left = 0, right = 0, freq = 0;
            // 使用双指针滑动窗口
            while (right < nums.length) {
                // 如果当前元素等于最大元素，增加频率
                if (nums[right] == maxElement) {
                    freq++;
                }
                // 当频率达到k时，计算子数组数量
                while (freq >= k) {
                    count += nums.length - right;
                    if (nums[left] == maxElement) {
                        freq--;
                    }
                    left++;
                }
                right++;
            }
            return count;
        }
    }


}
