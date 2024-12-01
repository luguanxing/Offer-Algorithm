package leetcode.contest.week426;

import java.util.*;

public class Test100444_识别数组中的最大异常值 {

    public static void main(String[] args) {
        System.out.println(new Solution().getLargestOutlier(new int[]{2, 3, 5, 10}));
        System.out.println(new Solution().getLargestOutlier(new int[]{-2, -1, -3, -6, 4}));
        System.out.println(new Solution().getLargestOutlier(new int[]{1, 1, 1, 1, 1, 5, 5}));
        System.out.println(new Solution().getLargestOutlier(new int[]{6, -31, 50, -35, 41, 37, -42, 13}));
        System.out.println(new Solution().getLargestOutlier(new int[]{752, 678, -483, -583, 201, 0, -886, -474, -171}));
    }

    static class Solution {
        public int getLargestOutlier(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int sum = Arrays.stream(nums).sum();
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                // 假设当前num是异常值，移除后sum-num至少有一个(sum-num)/2
                int leftover = sum - num;
                if (leftover % 2 != 0) {
                    continue;
                }
                int half = leftover / 2;
                if (map.containsKey(half)) {
                    if (half == num) {
                        if (map.get(half) > 1) {
                            max = Math.max(max, num);
                        }
                    } else {
                        max = Math.max(max, num);
                    }
                }
            }
            return max;
        }
    }

}
