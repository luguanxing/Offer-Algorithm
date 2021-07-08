package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0930_和相同的二元子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarraysWithSum(
                new int[]{1, 0, 1, 0, 1}, 2
        ));
        System.out.println(new Solution().numSubarraysWithSum(
                new int[]{0, 0, 0, 0, 0}, 0
        ));
        System.out.println(new Solution().numSubarraysWithSum(
                new int[]{0, 0, 0, 0, 0, 0}, 0
        ));
        System.out.println(new Solution().numSubarraysWithSum(
                new int[]{0, 0, 0}, 0
        ));
        System.out.println(new Solution().numSubarraysWithSum(
                new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 0
        ));
        System.out.println(new Solution().numSubarraysWithSum(
                new int[]{1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, 5
        ));
    }

    static class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int[] prefixSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
            int res = 0;
            Map<Integer, Integer> prefixSumCntMap = new HashMap<>();
            for (int i = 0; i <= nums.length; i++) {
                res += prefixSumCntMap.getOrDefault(prefixSum[i] - goal, 0);
                prefixSumCntMap.put(prefixSum[i], prefixSumCntMap.getOrDefault(prefixSum[i], 0) + 1);
            }
            return res;
        }
    }

    static class Solution_暴力 {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int[] prefixSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
            int res = 0;
            for (int i = 0; i <= nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (prefixSum[i] - prefixSum[j] == goal) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
