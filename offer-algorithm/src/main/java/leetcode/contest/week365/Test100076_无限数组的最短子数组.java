package leetcode.contest.week365;

import java.util.*;

public class Test100076_无限数组的最短子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSizeSubarray(new int[]{1, 2, 3}, 5));
        System.out.println(new Solution().minSizeSubarray(new int[]{1, 1, 1, 2, 3}, 4));
        System.out.println(new Solution().minSizeSubarray(new int[]{2, 4, 6, 8}, 3));
        System.out.println(new Solution().minSizeSubarray(new int[]{1, 6, 5, 5, 1, 1, 2, 5, 3, 1, 5, 3, 2, 4, 6, 6}, 56));
        System.out.println(new Solution().minSizeSubarray(new int[]{5, 5, 4, 1, 2, 2, 2, 3, 2, 4, 2, 5}, 56));
        System.out.println(new Solution().minSizeSubarray(new int[]{3, 2, 1, 3, 2, 1, 3, 1, 1, 1, 2, 1, 2, 1, 2, 3, 3, 1}, 78));
        System.out.println(new Solution().minSizeSubarray(new int[]{2, 1, 6, 5}, 69));
        System.out.println(new Solution().minSizeSubarray(new int[]{1, 6, 5, 5, 1, 1, 2, 5, 3, 1, 5, 3, 2, 4, 6, 6}, 56));
        System.out.println(new Solution().minSizeSubarray(new int[]{1, 2}, 72));
    }

    static class Solution {
        public int minSizeSubarray(int[] nums, int target) {
            // 求和
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (target % sum == 0) {
                return (int) ((target / sum) * nums.length);
            }

            // 当 target 大于数组总和时，将其减少
            int rounds = 0;
            if (target > sum) {
                rounds = (int) (target / sum); // 计算 target 是 sum 的多少倍
                target %= sum; // 更新 target 为余数
            }

            // 前缀和计算
            Map<Integer, Integer> prefixSum = new TreeMap<>();
            int currentSum = 0;
            int minLength = Integer.MAX_VALUE;
            for (int i = 0; i < 2 * nums.length; ++i) {
                currentSum += nums[i % nums.length];
                if (currentSum == target) {
                    minLength = Math.min(minLength, i + 1);
                }
                int diff = currentSum - target;
                if (prefixSum.containsKey(diff)) {
                    minLength = Math.min(minLength, i - prefixSum.get(diff));
                }
                prefixSum.put(currentSum, i);
            }
            if (minLength == Integer.MAX_VALUE) {
                return -1;
            }

            return minLength + rounds * nums.length;
        }
    }

}
