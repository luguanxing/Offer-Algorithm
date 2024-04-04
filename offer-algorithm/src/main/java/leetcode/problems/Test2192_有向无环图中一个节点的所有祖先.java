package leetcode.problems;

import java.util.*;

public class Test2192_有向无环图中一个节点的所有祖先 {

    public static void main(String[] args) {
        // n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
        System.out.println(new Solution().getAncestors(8, new int[][]{{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}}));
    }

    static class Solution {
        Map<Integer, TreeSet<Integer>> ancestorMap = new HashMap<>();
        Map<Integer, List<Integer>> reachMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            for (int i = 0; i < n; i++) {
                ancestorMap.put(i, new TreeSet<>());
            }
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                reachMap.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            }
            for (int i = 0; i < n; i++) {
                visited.clear();
                dfs(i, i);
            }
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(new ArrayList<>(ancestorMap.get(i)));
            }
            return res;
        }

        private void dfs(int root, int current) {
            if (visited.contains(current)) {
                return;
            }
            visited.add(current);
            for (int to : reachMap.getOrDefault(current, Collections.emptyList())) {
                ancestorMap.get(to).add(root);
                dfs(root, to);
            }
        }
    }

}
