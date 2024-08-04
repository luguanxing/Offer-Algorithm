package leetcode.contest.week409;

import java.util.*;

public class Q2_新增道路查询后的最短距离I {

    public static void main(String[] args) {
        // n = 5, queries = [[2, 4], [0, 2], [0, 4]]
        System.out.println(Arrays.toString(new Solution().shortestDistanceAfterQueries(5, new int[][]{{2, 4}, {0, 2}, {0, 4}})));
        // n = 4, queries = [[0, 3], [0, 2]]
        System.out.println(Arrays.toString(new Solution().shortestDistanceAfterQueries(4, new int[][]{{0, 3}, {0, 2}})));
    }

    static class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            Map<Integer, List<Integer>> reachMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                List<Integer> list = reachMap.getOrDefault(i, new ArrayList<>());
                list.add(i + 1);
                reachMap.put(i, list);
            }
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                reachMap.get(query[0]).add(query[1]);
                res[i] = checkTime(reachMap, n );
            }
            return res;
        }

        private int checkTime(Map<Integer, List<Integer>> reachMap, int n) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(0);
            int t = 0;
            while (!queue.isEmpty()) {
                List<Integer> currents = new ArrayList<>(queue);
                queue.clear();
                for (int current : currents) {
                    if (current == n) {
                        return t - 1;
                    }
                    visited.add(current);
                    List<Integer> nexts = reachMap.get(current);
                    for (int next : nexts) {
                        if (!visited.contains(next)) {
                            queue.add(next);
                        }
                    }
                }
                t++;
            }
            return n - 1;
        }
    }

}
