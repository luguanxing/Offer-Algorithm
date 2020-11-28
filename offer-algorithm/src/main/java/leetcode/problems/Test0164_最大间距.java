package leetcode.problems;

import java.util.Arrays;

public class Test0164_最大间距 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(new Solution().maximumGap(new int[]{10}));
    }

    static class Solution {
        public int maximumGap(int[] nums) {
            Arrays.sort(nums);
            int maxDiff = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                maxDiff = Math.max(maxDiff, nums[i + 1] - nums[i]);
            }
            return maxDiff;
        }
    }

}
