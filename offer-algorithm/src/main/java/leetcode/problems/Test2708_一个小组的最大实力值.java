package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test2708_一个小组的最大实力值 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxStrength(new int[]{3, -1, -5, 2, 5, -9}));
        System.out.println(new Solution().maxStrength(new int[]{-4, -5, -4}));
        System.out.println(new Solution().maxStrength(new int[]{0, -1}));
        System.out.println(new Solution().maxStrength(new int[]{0, 0}));
    }

    static class Solution {
        public long maxStrength(int[] nums) {
            Arrays.sort(nums);
            // 贪心：正数全要，负数要偶数个
            long res = 1;
            List<Integer> positives = Arrays.stream(nums).filter(i -> i > 0).boxed().collect(Collectors.toList());
            List<Integer> negatives = Arrays.stream(nums).filter(i -> i < 0).boxed().collect(Collectors.toList());
            for (int p : positives) {
                res *= p;
            }
            for (int i = 1; i < negatives.size(); i += 2) {
                res *= (long) negatives.get(i) * negatives.get(i - 1);
            }
            // 如果没有符合条件的数
            if (positives.isEmpty() && negatives.size() < 2) {
                res = nums[nums.length - 1];
            }
            return res;
        }
    }

}
