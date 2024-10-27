package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0684_冗余连接 {

    public static void main(String[] args) {
        // edges = [[1,2], [1,3], [2,3]]
        System.out.println(Arrays.toString(new Solution().findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        // edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
        System.out.println(Arrays.toString(new Solution().findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }

    static class Solution {
        public int[] findRedundantConnection(int[][] edges) {
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
            for (int i = 1; i <= len; i++) {
                map[i] = new ArrayList<>();
            }
            for (int[] edge : edgesList) {
                int from = edge[0];
                int to = edge[1];
                map[from].add(to);
                map[to].add(from);
            }
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(edgesList.get(0)[0]);
            visited.add(edgesList.get(0)[0]);
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

    static class Solution_并查集 {
        public int[] findRedundantConnection(int[][] edges) {
            int len = edges.length;
            UnionFind uf = new UnionFind(len + 1);
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                // 如果两个节点已经连通，说明这条边是冗余的
                if (uf.isConnected(from, to)) {
                    return edge;
                }
                uf.union(from, to);
            }
            return null;
        }

        class UnionFind {
            int[] parent;
            int[] weight;

            public UnionFind(int size) {
                parent = new int[size];
                weight = new int[size];
                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                    weight[i] = 1;
                }
            }

            public int find(int element) {
                while (element != parent[element]) {
                    parent[element] = parent[parent[element]];
                    element = parent[element];
                }
                return element;
            }

            public boolean isConnected(int element1, int element2) {
                int parent1 = find(element1);
                int parent2 = find(element2);
                return parent1 == parent2;
            }

            public void union(int element1, int element2) {
                int parent1 = find(element1);
                int parent2 = find(element2);
                // 按重量合并
                if (weight[parent1] > weight[parent2]) {
                    parent[parent2] = parent1;
                    weight[parent1] += weight[parent2];
                } else {
                    parent[parent1] = parent2;
                    weight[parent2] += weight[parent1];
                }
            }
        }
    }

}
