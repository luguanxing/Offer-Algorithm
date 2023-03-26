package leetcode.contest.week338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test6357_使数组元素全部相等的最少操作次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(
                new int[]{3, 1, 6, 8},
                new int[]{1, 5}
        ));
        System.out.println(new Solution().minOperations(
                new int[]{2, 9, 6, 3},
                new int[]{10}
        ));
    }

    static class Solution {
        public List<Long> minOperations(int[] nums, int[] queries) {
            // 计算排序后前后缀和
            int len = nums.length;
            Arrays.sort(nums);
            long[] prefixSum = new long[len];
            long[] suffixSum = new long[len];
            for (int i = 0; i < len; i++) {
                prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + nums[i];
            }
            for (int i = len - 1; i >= 0; i--) {
                suffixSum[i] = (i == len - 1 ? 0 : suffixSum[i + 1]) + nums[i];
            }
            // 从中间计算结果
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                int query = queries[i];
                int leftBound = leftBound(nums, query);
                int rightBound = rightBound(nums, query);
                long res = 0;
                res += (long) query * (leftBound) - (leftBound - 1 < 0 ? 0 : prefixSum[leftBound - 1]);
                res += (rightBound + 1 >= len ? 0 : suffixSum[rightBound + 1]) - (long) query * (len - rightBound - 1);
                list.add(res);
            }
            return list;
        }

        private int leftBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private int rightBound(int[] nums, int target) {
            int left = 0, right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left - 1;
        }
    }

}
