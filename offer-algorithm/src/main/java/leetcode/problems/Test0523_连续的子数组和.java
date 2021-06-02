package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0523_连续的子数组和 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkSubarraySum(
                new int[]{23, 2, 4, 6, 7}, 6
        ));
        System.out.println(new Solution().checkSubarraySum(
                new int[]{23, 2, 6, 4, 7}, 6
        ));
        System.out.println(new Solution().checkSubarraySum(
                new int[]{23, 2, 6, 4, 7}, 13
        ));
    }

    static class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int[] prefixSum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < prefixSum.length; i++) {
                int sum = prefixSum[i];
                int diff = sum % k;
                // 判断前缀和里是否有《同余数》+《上个距离大于1》的序号即可
                int lastIndex = map.getOrDefault(diff, i);
                if (i - lastIndex > 1) {
                    return true;
                }
                map.put(diff, Math.min(lastIndex, i));
            }
            return false;
        }
    }

}
