package leetcode.contest.week205;

import java.util.Arrays;

public class Test5509_避免重复字母的最小删除成本 {

    public static void main(String[] args) {
        System.out.println(new Solution().minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().minCost("abc", new int[]{1, 2, 3}));
        System.out.println(new Solution().minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
    }

    static class Solution {
        public int minCost(String s, int[] cost) {
            char[] chars = s.toCharArray();
            char lastChar = chars[0];
            int lastCost = cost[0];
            int sumCost = Arrays.stream(cost).sum();
            // 向后遍历一次，如果重复用最大值覆盖，那么去掉的就是最小的
            StringBuilder sb = new StringBuilder();
            int total = 0;
            for (int i = 1; i < chars.length; i++) {
                char currentChar = chars[i];
                int currentCost = cost[i];
                if (currentChar != lastChar) {
                    sb.append(lastChar);
                    total += lastCost;
                    lastChar = currentChar;
                    lastCost = currentCost;
                } else {
                    lastCost = Math.max(lastCost, currentCost);
                }
            }
            sb.append(lastChar);
            total += lastCost;
            return sumCost - total;
        }
    }

}
