package leetcode.problems;

import java.util.Arrays;

public class Test2740_找出分区值 {

    public static void main(String[] args) {
        System.out.println(new Solution().findValueOfPartition(new int[]{1, 3, 2, 4}));
        System.out.println(new Solution().findValueOfPartition(new int[]{100, 1, 10}));
    }

    static class Solution {
        public int findValueOfPartition(int[] nums) {
            Arrays.sort(nums);
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 1; i++) {
                res = Math.min(res, nums[i + 1] - nums[i]);
            }
            return res;
        }
    }

}
