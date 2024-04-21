package leetcode.contest.week394;

import java.util.*;

public class Test100276_最短路径中的边 {

    public static void main(String[] args) {
        // n = 6, edges = [[0,1,4],[0,2,1],[1,3,2],[1,4,3],[1,5,1],[2,3,1],[3,5,3],[4,5,2]]
        System.out.println(Arrays.toString(new Solution().findAnswer(6, new int[][]{{0, 1, 4}, {0, 2, 1}, {1, 3, 2}, {1, 4, 3}, {1, 5, 1}, {2, 3, 1}, {3, 5, 3}, {4, 5, 2}})));
        // n = 4, edges = [[2,0,1],[0,1,1],[0,3,4],[3,2,2]]
        System.out.println(Arrays.toString(new Solution().findAnswer(4, new int[][]{{2, 0, 1}, {0, 1, 1}, {0, 3, 4}, {3, 2, 2}})));
        // n = 3, edges = [[2,1,6]]
        System.out.println(Arrays.toString(new Solution().findAnswer(3, new int[][]{{2, 1, 6}})));
        // 6, [[4,1,7],[1,2,10]]
        System.out.println(Arrays.toString(new Solution().findAnswer(6, new int[][]{{4, 1, 7}, {1, 2, 10}})));
    }

    static class Solution {
        // 思路
        //  1. 先找所有最短路径距离，找不到直接返回
        //  2. 再次找所有最短路，若到达终点时距离等于最短路径，期间所有的路径标记
        //  3. 返回所有标记的路径
        public boolean[] findAnswer(int n, int[][] edges) {
            this.edges = edges;
            int minDistance = getMinDistance(n, edges);
            // System.out.println(minDistance);
            res = new boolean[edges.length];
            if (minDistance == -1) {
                return res;
            }
            dfs(0, 0, new LinkedHashSet<>());
            return res;
        }

        private List<List<int[]>> graph;
        private int[] distances;
        boolean[] res;
        int[][] edges;

        // 用于存储图的邻接表
        private List<List<int[]>> buildGraph(int n, int[][] edges) {
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int from = edge[0], to = edge[1], weight = edge[2];
                graph.get(from).add(new int[]{to, weight});
                graph.get(to).add(new int[]{from, weight}); // 由于是无向图，因此双向添加
            }
            return graph;
        }

        public int getMinDistance(int n, int[][] edges) {
            graph = buildGraph(n, edges);
            // 从源点 0 到所有点的最短距离数组，初始化为 Integer.MAX_VALUE
            distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[0] = 0;
            // 使用优先队列实现 Dijkstra 算法的主体
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[]{0, 0}); // 数组中保存节点索引和从源点到该节点的当前最短距离

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int currentNode = current[0];
                int currentDist = current[1];

                // 如果当前取出的节点距离大于已知最短距离，则跳过
                if (currentDist > distances[currentNode]) continue;

                // 遍历当前节点的所有邻接节点
                for (int[] neighbor : graph.get(currentNode)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    // 计算到邻接节点的可能更短的距离
                    int newDist = distances[currentNode] + weight;
                    // 如果计算的新距离更短，更新距离并放入队列
                    if (newDist < distances[nextNode]) {
                        distances[nextNode] = newDist;
                        pq.offer(new int[]{nextNode, newDist});
                    }
                }
            }

            // 返回从 0 到 n-1 的最短距离，如果 n-1 不可达，返回 Integer.MAX_VALUE
            return distances[n - 1] == Integer.MAX_VALUE ? -1 : distances[n - 1];
        }


        public void dfs(int currentNode, int currentCost, Set<Integer> path) {
            if (currentCost > distances[distances.length - 1]) {
                // 如果当前成本已经超过最短路径，停止递归
                return;
            }

            if (currentNode == distances.length - 1 && currentCost == distances[currentNode]) {
                // 到达目的地，且成本与最短路径成本相等
                List<Integer> list = new ArrayList<>(path);
                list.add(0, 0);
                System.out.println(list);
                for (int i = 0; i < list.size() - 1; i++) {
                    int from = list.get(i);
                    int to = list.get(i + 1);
                    for (int j = 0; j < res.length; j++) {
                        if ((edges[j][0] == from && edges[j][1] == to) || (edges[j][0] == to && edges[j][1] == from)) {
                            res[j] = true;
                        }
                    }
                }
                return;
            }

            // 遍历当前节点的所有邻接节点
            if (graph.get(currentNode) == null) {
                return;
            }
            for (int[] edge : graph.get(currentNode)) {
                int nextNode = edge[0];
                int weight = edge[1];
                int newCost = currentCost + weight;
                if (path.contains(nextNode)) {
                    continue; // 避免重复访问（同一条边只能访问一次
                }

                // 只考虑当前成本加上边的权重不超过到达该节点的最短路径成本的情况
                if (newCost <= distances[nextNode]) {
                    path.add(nextNode);
                    dfs(nextNode, newCost, path);
                    path.remove(nextNode);
                }
            }
        }
    }


}
