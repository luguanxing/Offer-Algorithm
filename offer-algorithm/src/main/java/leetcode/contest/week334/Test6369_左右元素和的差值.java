package leetcode.contest.week334;

import java.util.Arrays;

public class Test6369_左右元素和的差值 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().leftRigthDifference(new int[]{10, 4, 8, 3})));
        System.out.println(Arrays.toString(new Solution().leftRigthDifference(new int[]{1})));
    }

    static class Solution {
        public int[] leftRigthDifference(int[] nums) {
            int len = nums.length;
            int[] leftSum = new int[len];
            int[] rightSum = new int[len];
            for (int i = 1; i < len; i++) {
                leftSum[i] = leftSum[i - 1] + nums[i - 1];
            }
            for (int i = len - 2; i >= 0; i--) {
                rightSum[i] = rightSum[i + 1] + nums[i + 1];
            }
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = Math.abs(leftSum[i] - rightSum[i]);
            }
            return res;
        }
    }

}
