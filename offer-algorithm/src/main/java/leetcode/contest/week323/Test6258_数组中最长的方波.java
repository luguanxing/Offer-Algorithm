package leetcode.contest.week323;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test6258_数组中最长的方波 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestSquareStreak(new int[]{4, 3, 6, 16, 8, 2}));
        System.out.println(new Solution().longestSquareStreak(new int[]{2, 3, 5, 6, 7}));
    }

    static class Solution {
        public int longestSquareStreak(int[] nums) {
            Arrays.sort(nums);
            // dp[i]表示以i结尾的最长方波数
            // dp[i]=dp[j]+1其中j*j=i
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int sqrt = (int) Math.sqrt(num);
                if (sqrt * sqrt == num) {
                    map.put(num, map.getOrDefault(sqrt, 0) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            int max = map.values().stream().max(Integer::compareTo).get();
            return max <= 1 ? -1 : max;
        }
    }

}
