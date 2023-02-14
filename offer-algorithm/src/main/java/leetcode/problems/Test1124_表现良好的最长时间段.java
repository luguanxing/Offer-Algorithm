package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test1124_表现良好的最长时间段 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        System.out.println(new Solution().longestWPI(new int[]{6, 6, 6}));
        System.out.println(new Solution().longestWPI(new int[]{6, 9, 9}));
        System.out.println(new Solution().longestWPI(new int[]{9, 6, 9}));
        System.out.println(new Solution().longestWPI(new int[]{6, 6, 9}));
    }

    static class Solution {
        public int longestWPI(int[] hours) {
            int sum = 0;
            int maxLen = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < hours.length; i++) {
                int hour = hours[i];
                if (hour > 8) {
                    sum++;
                } else {
                    sum--;
                }
                // 保留相同sum下的更小下标
                map.putIfAbsent(sum, i);
                if (sum > 0) {
                    maxLen = Math.max(maxLen, i + 1);
                } else {
                    // 每次变动1，所以找更小的sum-1可能的下标
                    maxLen = Math.max(maxLen, i - map.getOrDefault(sum - 1, i));
                }
            }
            return maxLen;
        }
    }

    static class Solution_ON2 {
        public int longestWPI(int[] hours) {
            int len = hours.length;
            int[] prefixSum = new int[len + 1];
            for (int i = 0; i < len; i++) {
                prefixSum[i + 1] = prefixSum[i] + (hours[i] > 8 ? 1 : -1);
            }
            int max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    if (prefixSum[j + 1] - prefixSum[i] > 0) {
                        max = Math.max(max, j + 1 - i);
                    }
                }
            }
            return max;
        }
    }

}
