package leetcode.contest.week359;

import java.util.*;

public class Test7006_销售利润最大化 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximizeTheProfit(
                5, Arrays.asList(
                        Arrays.asList(0, 0, 1),
                        Arrays.asList(0, 2, 2),
                        Arrays.asList(1, 3, 2)
                )
        ));
        System.out.println(new Solution().maximizeTheProfit(
                5, Arrays.asList(
                        Arrays.asList(0, 0, 1),
                        Arrays.asList(0, 2, 10),
                        Arrays.asList(1, 3, 2)
                )
        ));
    }

    static class Solution {
        public int maximizeTheProfit(int n, List<List<Integer>> offers) {
            Map<Integer, List<List<Integer>>> map = new HashMap<>();
            for (List<Integer> offer : offers) {
                int end = offer.get(1);
                List<List<Integer>> list = map.getOrDefault(end, new ArrayList<>());
                list.add(offer);
                map.put(end, list);
            }
            // dp[i]表示销售前i所房屋所能获得的最大利润
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                // 不卖第i所房屋的情况
                dp[i] = dp[i - 1];
                // 卖到第i所房屋的情况
                for (List<Integer> offer : map.getOrDefault(i - 1, new ArrayList<>())) {
                    int start = offer.get(0);
                    int gold = offer.get(2);
                    dp[i] = Math.max(dp[i], (start > 0 ? dp[start] : 0) + gold);
                }
            }
            return dp[n];
        }
    }

}
