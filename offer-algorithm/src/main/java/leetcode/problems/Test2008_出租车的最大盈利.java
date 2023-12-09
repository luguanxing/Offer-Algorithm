package leetcode.problems;

import java.util.*;

public class Test2008_出租车的最大盈利 {

    public static void main(String[] args) {
        // n = 5, rides = [[2,5,4],[1,5,1]]
        System.out.println(new Solution().maxTaxiEarnings(5, new int[][]{{2, 5, 4}, {1, 5, 1}}));
        // n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
        System.out.println(new Solution().maxTaxiEarnings(20, new int[][]{{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}}));
    }

    static class Solution {
        public long maxTaxiEarnings(int n, int[][] rides) {
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int[] ride : rides) {
                map.computeIfAbsent(ride[1], k -> new ArrayList<>()).add(ride);
            }
            // dp[i] 表示第i个位置的最大盈利
            long[] dp = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1];
                for (int[] ride : map.getOrDefault(i, new ArrayList<>())) {
                    int start = ride[0];
                    int end = ride[1];
                    int tip = ride[2];
                    dp[i] = Math.max(dp[i], dp[start] + end - start + tip);
                }
            }
            return dp[n];
        }
    }

}
