package leetcode.problems;

import java.util.Arrays;

public class Test2616_最小化数对的最大差值 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
        System.out.println(new Solution().minimizeMax(new int[]{4, 2, 1, 2}, 1));
    }

    static class Solution {
        public int minimizeMax(int[] nums, int p) {
            Arrays.sort(nums);
            // 二分试出来最小的最大值
            int l = 0;
            int r = Integer.MAX_VALUE;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (getCnt(nums, m) >= p) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }

        private int getCnt(int[] nums, int maxDiff) {
            // 贪心获取最大值不超过maxDiff的数量
            int cnt = 0;
            for (int i = 1; i < nums.length; i++) {
                if (Math.abs(nums[i] - nums[i - 1]) <= maxDiff) {
                    cnt++;
                    i++;
                }
            }
            return cnt;
        }
    }

}
