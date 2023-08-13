package leetcode.contest.week358;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Test7022_限制条件下元素之间的最小绝对差 {

    public static void main(String[] args) {
        System.out.println(new Solution().minAbsoluteDifference(
                Arrays.asList(4, 3, 2, 4), 2
        ));
        System.out.println(new Solution().minAbsoluteDifference(
                Arrays.asList(5, 3, 2, 10, 15), 1
        ));
        System.out.println(new Solution().minAbsoluteDifference(
                Arrays.asList(1, 2, 3, 4), 3
        ));
        System.out.println(new Solution().minAbsoluteDifference(
                Arrays.asList(24, 121, 85, 83), 1
        ));
        System.out.println(new Solution().minAbsoluteDifference(
                Arrays.asList(24, 121, 85, 83), 0
        ));
    }

    static class Solution {
        public int minAbsoluteDifference(List<Integer> nums, int x) {
            if (x == 0) {
                return 0;
            }
            int n = nums.size();
            TreeMap<Integer, Integer> left = new TreeMap<>();
            int res = Integer.MAX_VALUE;
            for (int i = 0; i + x - 1 < n; i++) {
                if (!left.isEmpty()) {
                    int num = nums.get(i + x - 1);
                    // 更新答案
                    if (left.containsKey(num)) {
                        return 0;
                    }
                    if (left.lowerKey(num) != null) {
                        res = Math.min(res, Math.abs(num - left.lowerKey(num) ));
                    }
                    if (left.higherKey(num) != null) {
                        res = Math.min(res, Math.abs(num - left.higherKey(num) ));
                    }
                }
                if (i + x < n) {
                    left.put(nums.get(i), left.getOrDefault(nums.get(i), 0) + 1);
                }
            }
            return res;
        }
    }

}
