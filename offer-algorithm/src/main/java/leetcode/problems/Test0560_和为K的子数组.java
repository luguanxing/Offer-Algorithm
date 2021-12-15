package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0560_和为K的子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new Solution().subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(new Solution().subarraySum(new int[]{-1, 0, 1}, 0));
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> sumMap = new HashMap<>();
            int sum = 0;
            int res = 0;
            sumMap.put(0, 1);
            for (int num : nums) {
                sum += num;
                res += sumMap.getOrDefault(sum - k, 0);
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }

}
