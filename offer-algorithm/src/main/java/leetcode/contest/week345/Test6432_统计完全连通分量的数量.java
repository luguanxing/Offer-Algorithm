package leetcode.contest.week345;

import java.util.*;

public class Test6432_统计完全连通分量的数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().countCompleteComponents(6, new int[][]{
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4}
        }));
        System.out.println(new Solution().countCompleteComponents(6, new int[][]{
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4},
                {3, 5}
        }));
    }

    static class Solution {
        List<Integer> current;

        public int countCompleteComponents(int n, int[][] edges) {
            List<Set<Integer>> canReach = new ArrayList<>();
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                canReach.add(new HashSet<>());
            }
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                canReach.get(u).add(v);
                canReach.get(v).add(u);
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    current = new ArrayList<>();
                    dfs(i, canReach, visited);
                    boolean fullConnected = true;
                    for (int j = 0; j < current.size(); j++) {
                        for (int k = 0; k < current.size(); k++) {
                            if (j == k) {
                                continue;
                            }
                            if (!canReach.get(current.get(j)).contains(current.get(k))) {
                                fullConnected = false;
                            }
                        }
                    }
                    if (fullConnected) {
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(int node, List<Set<Integer>> graph, boolean[] visited) {
            current.add(node);
            visited[node] = true;
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, graph, visited);
                }
            }
        }
    }

}
