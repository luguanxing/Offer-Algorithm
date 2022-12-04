package leetcode.contest.week322;

import java.util.*;

public class Test6255_两个城市间路径的最小分数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minScore(
                4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}
        ));
        System.out.println(new Solution().minScore(
                4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}
        ));
    }

    static class Solution {
        Map<Integer, List<int[]>> reachMap;
        int[] cost;

        public int minScore(int n, int[][] roads) {
            reachMap = new HashMap<>();
            cost = new int[n + 1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            // init map
            for (int[] road : roads) {
                int from = road[0];
                int to = road[1];
                int cost = road[2];
                List<int[]> list1 = reachMap.getOrDefault(from, new ArrayList<>());
                int[] toAndCost = new int[]{to, cost};
                list1.add(toAndCost);
                reachMap.put(from, list1);
                List<int[]> list2 = reachMap.getOrDefault(to, new ArrayList<>());
                int[] fromAndCost = new int[]{from, cost};
                list2.add(fromAndCost);
                reachMap.put(to, list2);
            }
            // dfs(1)
            dfs(1, 100005);
            return Arrays.stream(cost).min().getAsInt();
        }

        private void dfs(int node, int currentCost) {
            if (currentCost < cost[node]) {
                cost[node] = currentCost;
            } else {
                return;
            }
            for (int[] next : reachMap.get(node)) {
                int to = next[0];
                int cost = next[1];
                dfs(to, Math.min(cost, currentCost));
            }
        }
    }

    static class Solution_猜想失败 {
        public int minScore(int n, int[][] roads) {
            int min = Integer.MAX_VALUE;
            for (int[] road : roads) {
                min = Math.min(min, road[2]);
            }
            return min;
        }
    }

}
