package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0525_连续数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[]{0, 1}));
        System.out.println(new Solution().findMaxLength(new int[]{0, 1, 0}));
        System.out.println(new Solution().findMaxLength(new int[]{0, 1, 0, 1, 1, 1, 0, 0, 0}));
    }

    static class Solution {
        public int findMaxLength(int[] nums) {
            int[] prefixSum = new int[nums.length + 1];
            // 原数组0变成-1求出前缀和
            for (int i = 1; i <= nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
            }
            // 找出前缀和相同最远的间距（需要map表示最小前缀和的下标）
            Map<Integer, Integer> minIndexMap = new HashMap<>();
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < prefixSum.length; i++) {
                int sum = prefixSum[i];
                int lastMinIndex = minIndexMap.getOrDefault(sum, i);
                res = Math.max(res, i - lastMinIndex);
                minIndexMap.put(sum, Math.min(i, lastMinIndex));
            }
            return res;
        }
    }

}
