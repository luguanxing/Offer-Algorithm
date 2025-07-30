package leetcode.problems;

import java.util.*;

public class Test2419_按位与最大的最长子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{1, 2, 3, 3, 2, 2}));
        System.out.println(new Solution().longestSubarray(new int[]{1, 2, 3, 4}));
    }

    static class Solution {
        public int longestSubarray(int[] nums) {
            int max = Arrays.stream(nums).max().getAsInt();
            int cnt = 0;
            int maxCnt = 0;
            for (int num : nums) {
                if (num == max) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }
            return maxCnt;
        }
    }

}
