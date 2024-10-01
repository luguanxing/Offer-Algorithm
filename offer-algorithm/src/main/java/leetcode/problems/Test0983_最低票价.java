package leetcode.problems;

import java.util.*;

public class Test0983_最低票价 {

    public static void main(String[] args) {
        // days = [1,4,6,7,8,20], costs = [2,7,15]
        System.out.println(new Solution().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        // days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
        System.out.println(new Solution().mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
        System.out.println(new Solution().mincostTickets(new int[]{1, 5, 8, 9, 10, 12, 13, 16, 17, 18, 19, 20, 23, 24, 29}, new int[]{3, 12, 54}));
        System.out.println(new Solution().mincostTickets(new int[]{1, 2, 3, 4, 6, 8, 9, 10, 13, 14, 16, 17, 19, 21, 24, 26, 27, 28, 29}, new int[]{3, 14, 50}));
    }

    static class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            // 穷举生成每一天的最低票价
            int[] dp = new int[500];
            Arrays.fill(dp, Integer.MAX_VALUE);
            int last = 0;
            for (int day : days) {
                // 当天
                dp[day] = Math.min(dp[day], last + costs[0]);
                // 7天票
                for (int i = 0; i < 7; i++) {
                    dp[day + i] = Math.min(dp[day + i], last + costs[1]);
                }
                // 30天票
                for (int i = 0; i < 30; i++) {
                    dp[day + i] = Math.min(dp[day + i], last + costs[2]);
                }
                last = dp[day];
            }
            return dp[days[days.length - 1]];
        }
    }

    static class Solution_DP {
        public int mincostTickets(int[] days, int[] costs) {
            // dp[i]表示到第days[i]天的最低消费
            int len = days.length;
            TreeMap<Integer, Integer> daySet = new TreeMap<>();
            for (int i = 0; i < len; i++) {
                daySet.put(days[i], i);
            }
            int[] dp = new int[len];
            for (int i = 0; i < len; i++) {
                int day = days[i];
                // 买1天的票
                int dp1 = costs[0] + (i > 0 ? dp[i - 1] : 0);
                // 买7天的票
                int dp2 = costs[1] + (i > 0 ? dp[i - 1] : 0);
                if (daySet.containsKey(day - 7)) {
                    int day7idx = daySet.get(day - 7);
                    dp2 = Math.min(dp2, dp[day7idx] + costs[1]);
                } else {
                    int day7idx = daySet.higherEntry(day - 7).getValue() - 1;
                    if (day7idx >= 0) {
                        dp2 = Math.min(dp2, dp[day7idx] + costs[1]);
                    } else {
                        dp2 = Math.min(dp2, costs[1]);
                    }
                }
                // 买30天的票
                int dp3 = costs[2] + (i > 0 ? dp[i - 1] : 0);
                if (daySet.containsKey(day - 30)) {
                    int day30idx = daySet.get(day - 30);
                    dp3 = Math.min(dp3, dp[day30idx] + costs[2]);
                } else {
                    int day30idx = daySet.higherEntry(day - 30).getValue() - 1;
                    if (day30idx >= 0) {
                        dp3 = Math.min(dp3, dp[day30idx] + costs[2]);
                    } else {
                        dp3 = Math.min(dp3, costs[2]);
                    }
                }
                dp[i] = Math.min(dp1, Math.min(dp2, dp3));
            }
            return dp[len - 1];
        }
    }

}
