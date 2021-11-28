package leetcode.contest.week269;

import java.util.Arrays;

public class Test5940_从数组中移除最大值和最小值 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6}));
        System.out.println(new Solution().minimumDeletions(new int[]{0, -4, 19, 1, 8, -2, -3, 5}));
        System.out.println(new Solution().minimumDeletions(new int[]{1}));
        System.out.println(new Solution().minimumDeletions(new int[]{-14, 61, 29, -18, 59, 13, -67, -16, 55, -57, 7, 74}));
    }

    static class Solution {
        public int minimumDeletions(int[] nums) {
            int max = Arrays.stream(nums).max().orElse(0);
            int min = Arrays.stream(nums).min().orElse(0);
            int maxIndex = 0;
            int minIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max) {
                    maxIndex = i;
                }
                if (nums[i] == min) {
                    minIndex = i;
                }
            }
            int len = nums.length;
            int bothLeft = Math.max(maxIndex, minIndex) + 1;
            int bothRight = Math.max(len - maxIndex, len - minIndex);
            int leftRight = maxIndex < minIndex ? maxIndex + 1 + len - minIndex : minIndex + 1 + len - maxIndex;
            int res = Math.min(leftRight, Math.min(bothRight, bothLeft));
            return res;
        }
    }

}
