package leetcode.contest.week312;

import java.util.Arrays;

public class Test6189_按位与最大的最长子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{1, 2, 3, 3, 2, 2}));
        System.out.println(new Solution().longestSubarray(new int[]{1, 2, 3, 4}));
    }

    static class Solution {
        public int longestSubarray(int[] nums) {
            int maxAndResult = Arrays.stream(nums).max().getAsInt();
            int maxLen = 1;
            int currentAndLen = 1;
            int currentAndResult = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int andResult = currentAndResult & nums[i];
                if (andResult == maxAndResult) {
                    currentAndLen++;
                } else {
                    currentAndLen = 1;
                    currentAndResult = nums[i];
                }
                maxLen = Math.max(maxLen, currentAndLen);
            }
            return maxLen;
        }
    }

}
