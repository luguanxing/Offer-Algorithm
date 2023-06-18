package leetcode.contest.week350;

import java.util.Arrays;

public class Test6890_找出分区值 {

    public static void main(String[] args) {
        System.out.println(new Solution().findValueOfPartition(new int[]{1, 3, 2, 4}));
        System.out.println(new Solution().findValueOfPartition(new int[]{100, 1, 10}));
    }

    static class Solution {
        public int findValueOfPartition(int[] nums) {
            Arrays.sort(nums);
            int diff = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                diff = Math.min(diff, nums[i] - nums[i - 1]);
            }
            return diff;
        }
    }

}
