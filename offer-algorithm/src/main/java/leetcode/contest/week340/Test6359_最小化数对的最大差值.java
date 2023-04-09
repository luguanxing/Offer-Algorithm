package leetcode.contest.week340;

import java.util.Arrays;

public class Test6359_最小化数对的最大差值 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
        System.out.println(new Solution().minimizeMax(new int[]{4, 2, 1, 2}, 1));
        System.out.println(new Solution().minimizeMax(new int[]{3, 0, 5, 0, 0, 1, 6}, 3));
        System.out.println(new Solution().minimizeMax(new int[]{1, 0, 1, 5, 6, 5, 6, 4}, 4));
    }

    static class Solution {
        public int minimizeMax(int[] nums, int p) {
            // 二分查找，不断试出能比p多的《最大差值的最小值》
            Arrays.sort(nums);
            int left = 0;
            int right = Arrays.stream(nums).max().getAsInt();
            while (left <= right) {
                int mid = (left + right) / 2;
                int pair = getPair(nums, mid);
                if (pair >= p) {
                    // 多于p个，继续尝试压缩
                    right = mid - 1;
                } else {
                    // 少于p个，增加范围
                    left = mid + 1;
                }
            }
            return left;
        }

        private int getPair(int[] nums, int limit) {
            int pair = 0;
            Integer last = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                if (last != null && num - last <= limit) {
                    pair++;
                    last = null;
                } else {
                    last = num;
                }
            }
            return pair;
        }
    }

}
