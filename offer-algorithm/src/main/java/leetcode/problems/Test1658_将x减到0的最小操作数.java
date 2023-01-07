package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1658_将x减到0的最小操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(new Solution().minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println(new Solution().minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
        System.out.println(new Solution().minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365));
    }

    static class Solution {
        public int minOperations(int[] nums, int x) {
            int total = Arrays.stream(nums).sum();
            Map<Integer, Integer> previousSumMap = new HashMap<>();
            previousSumMap.put(0, -1);
            int currentSum = 0;
            int maxLen = -1;
            for (int i = 0; i < nums.length; i++) {
                currentSum += nums[i];
                previousSumMap.put(currentSum, previousSumMap.getOrDefault(currentSum, i));
                // currentSum - previousSum = total - x
                // previousSum = currentSum + x - total
                if (previousSumMap.containsKey(currentSum + x - total)) {
                    maxLen = Math.max(maxLen, i - previousSumMap.get(currentSum + x - total));
                }
            }
            return maxLen == -1 ? -1 : nums.length - maxLen;
        }
    }

}
