package leetcode.problems;

import java.util.*;

public class Test2050_并行课程III {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTime(
                3,
                new int[][]{{1, 3}, {2, 3}},
                new int[]{3, 2, 5}
        ));
        System.out.println(new Solution().minimumTime(
                5,
                new int[][]{{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}},
                new int[]{1, 2, 3, 4, 5}
        ));
        System.out.println(new Solution().minimumTime(
                1,
                new int[][]{},
                new int[]{1}
        ));
    }

    static class Solution {
        Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();
        Map<Integer, Integer> costMap = new HashMap<>();

        public int minimumTime(int n, int[][] relations, int[] time) {
            for (int[] relation : relations) {
                int from = relation[0];
                int to = relation[1];
                List<Integer> list = prerequisiteMap.getOrDefault(to, new ArrayList<>());
                list.add(from);
                prerequisiteMap.put(to, list);
            }
            // 记忆化搜索+DFS
            int max = 0;
            for (int p = 1; p <= n; p++) {
                max = Math.max(max, getCost(p, time));
            }
            return max;
        }

        private int getCost(int p, int[] time) {
            if (costMap.containsKey(p)) {
                return costMap.get(p);
            }
            int prerequisiteCost = 0;
            for (int prerequisite : prerequisiteMap.getOrDefault(p, new ArrayList<>())) {
                prerequisiteCost = Math.max(prerequisiteCost, getCost(prerequisite, time));
            }
            int cost = prerequisiteCost + time[p - 1];
            costMap.put(p, cost);
            return cost;
        }
    }

}
