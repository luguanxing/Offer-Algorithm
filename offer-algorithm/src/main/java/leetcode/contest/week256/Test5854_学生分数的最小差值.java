package leetcode.contest.week256;

import java.util.Arrays;

public class Test5854_学生分数的最小差值 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumDifference(
                new int[]{90}, 1
        ));
        System.out.println(new Solution().minimumDifference(
                new int[]{9, 4, 1, 7}, 2
        ));
    }

    static class Solution {
        public int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums);
            int right = k - 1;
            int left = 0;
            int min = nums[right] - nums[left];
            while (right < nums.length) {
                min = Math.min(min, nums[right++] - nums[left++]);
            }
            return min;
        }
    }

}
