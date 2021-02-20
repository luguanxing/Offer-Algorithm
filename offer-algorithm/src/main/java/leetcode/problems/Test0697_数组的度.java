package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0697_数组的度 {

    public static void main(String[] args) {
        System.out.println(new Solution().findShortestSubArray(new int[]{0}));
        System.out.println(new Solution().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(new Solution().findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    static class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            Map<Integer, Integer> leftMap = new HashMap<>();
            Map<Integer, Integer> rightMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int left = leftMap.getOrDefault(num, Integer.MAX_VALUE);
                leftMap.put(num, Math.min(left, i));
                int right = rightMap.getOrDefault(num, Integer.MIN_VALUE);
                rightMap.put(num, Math.max(right, i));
                cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
            }
            int res = Integer.MAX_VALUE;
            List<Integer> list = new ArrayList<>(cntMap.values());
            Collections.sort(list);
            int degree = list.get(list.size() - 1);
            for (int num : nums) {
                if (cntMap.get(num) == degree) {
                    res = Math.min(res, rightMap.get(num) - leftMap.get(num) + 1);
                }
            }
            return res;
        }
    }

}
