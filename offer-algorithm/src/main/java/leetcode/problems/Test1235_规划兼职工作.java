package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Test1235_规划兼职工作 {

    public static void main(String[] args) {
        System.out.println(new Solution().jobScheduling(
                new int[]{1, 2, 3, 3},
                new int[]{3, 4, 5, 6},
                new int[]{50, 10, 40, 70}
        ));
        System.out.println(new Solution().jobScheduling(
                new int[]{1, 2, 3, 4, 6},
                new int[]{3, 5, 10, 6, 9},
                new int[]{20, 20, 100, 70, 60}
        ));
        System.out.println(new Solution().jobScheduling(
                new int[]{1, 1, 1},
                new int[]{2, 3, 4},
                new int[]{5, 6, 4}
        ));
        System.out.println(new Solution().jobScheduling(
                new int[]{4, 2, 4, 8, 2},
                new int[]{5, 5, 5, 10, 8},
                new int[]{1, 2, 8, 10, 4}
        ));
        System.out.println(new Solution().jobScheduling(
                new int[]{6, 15, 7, 11, 1, 3, 16, 2},
                new int[]{19, 18, 19, 16, 10, 8, 19, 8},
                new int[]{2, 9, 1, 19, 5, 7, 3, 19}
        ));
        System.out.println(new Solution().jobScheduling(
                new int[]{43, 13, 36, 31, 40, 5, 47, 13, 28, 16, 2, 11},
                new int[]{44, 22, 41, 41, 47, 13, 48, 35, 48, 26, 21, 39},
                new int[]{8, 20, 3, 19, 16, 8, 11, 13, 2, 15, 1, 1}
        ));
    }

    static class Solution {
        public int jobScheduling(int[] startTimes, int[] endTimes, int[] profits) {
            // dp[e]表示时间为e时间之前的最大利润
            int[][] infos = new int[startTimes.length][3];
            for (int i = 0; i < startTimes.length; i++) {
                infos[i] = new int[]{startTimes[i], endTimes[i], profits[i]};
            }
            Arrays.sort(infos, Comparator.comparingInt(o -> o[1]));
            TreeMap<Integer, Integer> dp = new TreeMap<>();
            dp.put(infos[0][1], infos[0][2]);
            // dp[e] = max(dp[s]+p, dp[e-1])
            for (int i = 1; i < startTimes.length; i++) {
                int startTime = infos[i][0];
                int endTime = infos[i][1];
                int profit = infos[i][2];
                int notChooseI = 0;
                if (dp.lowerKey(endTime) != null) {
                    notChooseI = dp.get(dp.lowerKey(endTime));
                }
                int chooseI = profit;
                if (dp.lowerKey(startTime + 1) != null) {
                    chooseI += dp.lowerEntry(startTime + 1).getValue();
                }
                // 设置dp[i]
                int oldMaxI = dp.getOrDefault(endTime, 0);
                int maxI = Math.max(chooseI, notChooseI);
                dp.put(endTime, Math.max(maxI, oldMaxI));
            }
            return dp.values().stream().max(Integer::compareTo).get();
        }
    }

}
