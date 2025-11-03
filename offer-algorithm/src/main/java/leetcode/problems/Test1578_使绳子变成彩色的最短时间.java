package leetcode.problems;

import java.util.*;

public class Test1578_使绳子变成彩色的最短时间 {

    public static void main(String[] args) {
        // colors = "abaac", neededTime = [1,2,3,4,5]
        System.out.println(new Solution().minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        // colors = "abc", neededTime = [1,2,3]
        System.out.println(new Solution().minCost("abc", new int[]{1, 2, 3}));
        // colors = "aabaa", neededTime = [1,2,3,4,1]
        System.out.println(new Solution().minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        // "aaabbbabbbb", [3,5,10,7,5,3,5,5,4,8,1]
        System.out.println(new Solution().minCost("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}));
    }

    static class Solution {
        public int minCost(String colors, int[] neededTime) {
            int len = colors.length();
            char[] chars = colors.toCharArray();
            int res = 0;
            // 遇到连续相同的，保留neededTime最大的
            for (int left = 0; left < len - 1; ) {
                int right = left;
                int maxTime = 0;
                int sumOfTime = 0;
                while (right < len && chars[right] == chars[left]) {
                    maxTime = Math.max(maxTime, neededTime[right]);
                    sumOfTime += neededTime[right];
                    right++;
                }
                res += sumOfTime - maxTime;
                left = right;
            }
            return res;
        }
    }

    static class Solution_Stack {
        public int minCost(String colors, int[] neededTime) {
            int len = colors.length();
            char[] chars = colors.toCharArray();
            int res = 0;
            // 遇到连续相同的，保留neededTime最大的
            PriorityQueue<Integer> neededTimeList = new PriorityQueue<>(Collections.reverseOrder());
            for (int left = 0; left < len - 1; ) {
                int right = left;
                while (right < len && chars[right] == chars[left]) {
                    neededTimeList.add(neededTime[right]);
                    right++;
                }
                neededTimeList.poll();
                while (!neededTimeList.isEmpty()) {
                    res += neededTimeList.poll();
                }
                left = right;
            }
            return res;
        }
    }

}
