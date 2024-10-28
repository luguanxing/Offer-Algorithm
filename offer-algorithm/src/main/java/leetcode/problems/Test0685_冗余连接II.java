package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0685_冗余连接II {

    public static void main(String[] args) {
        // edges = [[1,2],[1,3],[2,3]]
        System.out.println(Arrays.toString(new Solution().findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        // edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
        System.out.println(Arrays.toString(new Solution().findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})));
        // edges = [[1,2],[2,3],[3,1],[4,1]]
        System.out.println(Arrays.toString(new Solution().findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 1}, {4, 1}})));
        // edges = [[2,1],[3,1],[4,2],[1,4]]
        System.out.println(Arrays.toString(new Solution().findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}})));
    }

    static class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int len = edges.length;
            List<int[]> edgesList = Arrays.stream(edges).collect(Collectors.toList());
            for (int i = len - 1; i >= 0; i--) {
                int[] edge = edgesList.get(i);
                edgesList.remove(i);
                if (isConnected(len, edgesList)) {
                    return edge;
                }
                edgesList.add(i, edge);
            }
            return null;
        }

        private boolean isConnected(int len, List<int[]> edgesList) {
            List<Integer>[] map = new List[len + 1];
            int[] in = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                map[i] = new ArrayList<>();
            }
            for (int[] edge : edgesList) {
                int from = edge[0];
                int to = edge[1];
                map[from].add(to);
                in[to]++;
            }
            // 找入度为0的节点开始BFS
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= len; i++) {
                if (in[i] == 0) {
                    queue.add(i);
                    visited.add(i);
                    break;
                }
            }
            while (!queue.isEmpty()) {
                List<Integer> currents = new ArrayList<>(queue);
                queue.clear();
                for (int current : currents) {
                    for (int next : map[current]) {
                        if (!visited.contains(next)) {
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            return visited.size() == len;
        }
    }

}
