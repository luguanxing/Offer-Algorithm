package leetcode.problems;

import java.util.Arrays;

public class Test2270_分割数组的方案数 {

    public static void main(String[] args) {
        System.out.println(new Solution().waysToSplitArray(new int[]{10, 4, -8, 7}));
        System.out.println(new Solution().waysToSplitArray(new int[]{2, 3, 1, 0}));
    }

    static class Solution {
        public int waysToSplitArray(int[] nums) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            long currentSum = 0;
            int res = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                currentSum += nums[i];
                if (currentSum >= sum - currentSum) {
                    res++;
                }
            }
            return res;
        }
    }

}
