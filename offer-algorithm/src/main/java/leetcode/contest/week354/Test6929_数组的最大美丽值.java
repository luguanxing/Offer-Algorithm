package leetcode.contest.week354;

import java.util.*;

public class Test6929_数组的最大美丽值 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumBeauty(new int[]{4, 6, 1, 2}, 2));
        System.out.println(new Solution().maximumBeauty(new int[]{1, 1, 1, 1}, 10));
        System.out.println(new Solution().maximumBeauty(new int[]{27, 56, 27, 40}, 6));
        System.out.println(new Solution().maximumBeauty(new int[]{38, 11, 31, 15, 50, 15}, 0));
        System.out.println(new Solution().maximumBeauty(new int[]{57, 78, 75, 84, 42, 9, 84, 81, 41, 21, 23}, 2));
    }

    static class Solution {
        public int maximumBeauty(int[] nums, int k) {
            // 先排序
            Arrays.sort(nums);
            int maxBeauty = 0;
            int left = 0;
            int right = 0;
            // 使用滑动窗口，求不超过2K范围的最大窗口长度
            while (right < nums.length) {
                int diff = nums[right] - nums[left];
                if (diff <= 2 * k) {
                    maxBeauty = Math.max(maxBeauty, right - left + 1);
                    right++;
                } else {
                    left++;
                }
            }
            return maxBeauty;
        }
    }

}
