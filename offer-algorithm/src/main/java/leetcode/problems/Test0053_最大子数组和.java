package leetcode.problems;

import java.util.TreeSet;

public class Test0053_最大子数组和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray(new int[]{1}));
        System.out.println(new Solution().maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(new Solution().maxSubArray(new int[]{1, 2, -1}));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int currentSum = 0;
            for (int num : nums) {
                currentSum += num;
                max = Math.max(max, currentSum);
                if (currentSum < 0) {
                    currentSum = 0;
                }
            }
            return max;
        }
    }

    static class Solution2 {
        public int maxSubArray(int[] nums) {
            TreeSet<Integer> prefixSum = new TreeSet<>();
            int max = Integer.MIN_VALUE;
            int currentSum = 0;
            for (int num : nums) {
                currentSum += num;
                max = Math.max(max, currentSum);
                max = Math.max(max, currentSum - (prefixSum.isEmpty() ? 0 : prefixSum.first()));
                prefixSum.add(currentSum);
            }
            return max;
        }
    }

}
