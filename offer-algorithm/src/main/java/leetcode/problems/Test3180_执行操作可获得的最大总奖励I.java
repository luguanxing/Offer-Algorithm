package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Test3180_执行操作可获得的最大总奖励I {

    public static void main(String[] args) {
        System.out.println(new Solution().maxTotalReward(new int[]{1, 1, 3, 3}));
        System.out.println(new Solution().maxTotalReward(new int[]{1, 6, 4, 3, 2}));
    }

    static class Solution {
        public int maxTotalReward(int[] rewardValues) {
            Arrays.sort(rewardValues);
            int len = rewardValues.length;
            int max = Arrays.stream(rewardValues).max().getAsInt();
            boolean[] dp = new boolean[2 * max + 1];
            dp[0] = true;
            int res = 0;
            for (int rewardValue : rewardValues) {
                for (int i = 0; i < rewardValue; i++) {
                    if (dp[i]) {
                        dp[i + rewardValue] = true;
                        res = Math.max(res, i + rewardValue);
                    }
                }
            }
            return res;
        }
    }

    static class Solution_穷举 {
        public int maxTotalReward(int[] rewardValues) {
            Arrays.sort(rewardValues);
            // 使用TreeSet来存储当前所有可能的和
            TreeSet<Integer> currentSums = new TreeSet<>();
            for (int rewardValue : rewardValues) {
                List<Integer> newSums = new ArrayList<>();
                for (int currentSum : currentSums) {
                    if (currentSum < rewardValue) {
                        newSums.add(currentSum + rewardValue);
                    }
                }
                currentSums.add(rewardValue);
                currentSums.addAll(newSums);
            }
            return currentSums.pollLast();
        }
    }

    static class Solution_背包 {
        public int maxTotalReward(int[] rewardValues) {
            Arrays.sort(rewardValues);
            int MAX = 5000;
            // dp[i][j] 表示用前i个物品能否凑出j的总和，相当于背包问题
            // dp[i][j] |= dp[i-1][j]
            // dp[i][j] |= dp[i-1][j-rewardValues[i]] 且 rewardValues[i]<=j && j-rewardValues[i]<rewardValues[i]
            // 可以化简成dp[j] = dp[j] || dp[j-v]其中v<=j<2*v
            boolean[] dp = new boolean[MAX];
            for (int v : rewardValues) {
                dp[v] = true;
                for (int j = 0; j < MAX; j++) {
                    if (v <= j && j < 2 * v) {
                        dp[j] |= dp[j - v];
                    }
                }
            }
            int res = 0;
            for (int i = 1; i < MAX; i++) {
                if (dp[i]) {
                    res = i;
                }
            }
            return res;
        }
    }

}
