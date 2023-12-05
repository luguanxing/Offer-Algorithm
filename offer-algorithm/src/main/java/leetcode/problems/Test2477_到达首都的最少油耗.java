package leetcode.problems;

import java.util.*;

public class Test2477_到达首都的最少油耗 {

    public static void main(String[] args) {
        // roads = [[0,1],[0,2],[0,3]], seats = 5
        System.out.println(new Solution().minimumFuelCost(new int[][]{{0, 1}, {0, 2}, {0, 3}}, 5));

        // roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
        System.out.println(new Solution().minimumFuelCost(new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2));

        // roads = [], seats = 1
        System.out.println(new Solution().minimumFuelCost(new int[][]{}, 1));
    }

    static class Solution {
        Map<Integer, List<Integer>> reachMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int seats;

        public long minimumFuelCost(int[][] roads, int seats) {
            this.seats = seats;
            for (int[] road : roads) {
                int from = road[0];
                int to = road[1];
                reachMap.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
                reachMap.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
            }
            return getCostAndCnt(0)[0];
        }

        private long[] getCostAndCnt(int current) {
            visited.add(current);
            long cost = 0;
            long cnt = 1;
            for (int next : reachMap.getOrDefault(current, new ArrayList<>())) {
                if (visited.contains(next)) {
                    continue;
                }
                long[] nextCostCnt = getCostAndCnt(next);
                long nextCost = nextCostCnt[0];
                long nextCnt = nextCostCnt[1];
                cost += nextCost + (nextCnt + seats - 1) / seats;
                cnt += nextCnt;
            }
            return new long[]{cost, cnt};
        }
    }

}
