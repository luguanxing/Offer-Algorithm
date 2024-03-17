package leetcode.problems;

import java.util.*;

public class Test0310_最小高度树 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMinHeightTrees(
                4, new int[][]{{1, 0}, {1, 2}, {1, 3}}
        ));
        System.out.println(new Solution().findMinHeightTrees(
                6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}
        ));
        System.out.println(new Solution().findMinHeightTrees(
                1, new int[][]{}
        ));
        System.out.println(new Solution().findMinHeightTrees(
                6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}}
        ));

        System.out.println();
        System.out.println(new Solution_DFS().findMinHeightTrees(
                4, new int[][]{{1, 0}, {1, 2}, {1, 3}}
        ));
        System.out.println(new Solution_DFS().findMinHeightTrees(
                6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}
        ));
    }


    static class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                cntMap.put(i, 0);
            }
            Map<Integer, Set<Integer>> neighborMap = new HashMap<>();
            for (int[] edge : edges) {
                int p1 = edge[0];
                int p2 = edge[1];
                cntMap.put(p1, cntMap.getOrDefault(p1, 0) + 1);
                cntMap.put(p2, cntMap.getOrDefault(p2, 0) + 1);
                Set<Integer> p1Neighbors = neighborMap.getOrDefault(p1, new HashSet<>());
                p1Neighbors.add(p2);
                neighborMap.put(p1, p1Neighbors);
                Set<Integer> p2Neighbors = neighborMap.getOrDefault(p2, new HashSet<>());
                p2Neighbors.add(p1);
                neighborMap.put(p2, p2Neighbors);
            }
            // 不断剔除出现次数为1的点直到只剩下一个或两个
            while (cntMap.size() > 2) {
                List<Integer> removes = new ArrayList<>();
                for (int node : cntMap.keySet()) {
                    int cnt = cntMap.get(node);
                    if (cnt == 1 || cnt == 0) {
                        removes.add(node);
                    }
                }
                for (int remove : removes) {
                    cntMap.remove(remove);
                    for (int neighbor : neighborMap.get(remove)) {
                        if (!cntMap.containsKey(neighbor)) {
                            continue;
                        }
                        cntMap.put(neighbor, cntMap.get(neighbor) - 1);
                        if (cntMap.get(neighbor) == 0) {
                            cntMap.remove(remove);
                        }
                    }
                }
            }
            return new ArrayList<>(cntMap.keySet());
        }
    }

    static class Solution_DFS {
        private Map<Integer, Set<Integer>> neighborMap = new HashMap<>();
        private Set<Integer> visited = new HashSet<>();
        private int[] maxDepths;

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            maxDepths = new int[n];
            for (int[] edge : edges) {
                int p1 = edge[0];
                int p2 = edge[1];
                Set<Integer> p1Neighbors = neighborMap.getOrDefault(p1, new HashSet<>());
                p1Neighbors.add(p2);
                neighborMap.put(p1, p1Neighbors);
                Set<Integer> p2Neighbors = neighborMap.getOrDefault(p2, new HashSet<>());
                p2Neighbors.add(p1);
                neighborMap.put(p2, p2Neighbors);
            }
            for (int i = 0; i < n; i++) {
                visited.clear();
                dfs(i, 0);
            }
            int max = Arrays.stream(maxDepths).min().getAsInt();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (maxDepths[i] == max) {
                    result.add(i);
                }
            }
            return result;
        }

        private void dfs(int index, int depth) {
            if (visited.contains(index)) {
                return;
            }
            visited.add(index);
            maxDepths[index] = Math.max(maxDepths[index], depth);
            for (int neighbor : neighborMap.getOrDefault(index, new HashSet<>())) {
                dfs(neighbor, depth + 1);
            }
        }
    }


}
