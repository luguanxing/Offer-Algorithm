package leetcode.contest.week249;

import java.util.Arrays;

public class Test5808_数组串联 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getConcatenation(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(new Solution().getConcatenation(new int[]{1, 3, 2, 1})));
    }

    static class Solution {
        public int[] getConcatenation(int[] nums) {
            int[] res = new int[2 * nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i];
                res[i + nums.length] = nums[i];
            }
            return res;
        }
    }

}
