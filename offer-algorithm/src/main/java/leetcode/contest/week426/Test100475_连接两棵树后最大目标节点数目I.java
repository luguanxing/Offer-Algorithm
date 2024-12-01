package leetcode.contest.week426;

import java.util.*;

public class Test100475_连接两棵树后最大目标节点数目I {

    public static void main(String[] args) {
        // edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2
        System.out.println(Arrays.toString(new Solution().maxTargetNodes(new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}}, new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}}, 2)));
        // edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]], k = 1
        System.out.println(Arrays.toString(new Solution().maxTargetNodes(new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}}, new int[][]{{0, 1}, {1, 2}, {2, 3}}, 1)));
    }

    static class Solution {
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
            // 创建两棵树的邻接表
            List<List<Integer>> adj1 = new ArrayList<>();
            List<List<Integer>> adj2 = new ArrayList<>();
            int n = 0;
            int m = 0;
            for (int[] edge : edges1) {
                n = Math.max(n, Math.max(edge[0], edge[1]));
            }
            n += 1;
            for (int[] edge : edges2) {
                m = Math.max(m, Math.max(edge[0], edge[1]));
            }
            m += 1;
            for (int i = 0; i < n; i++) {
                adj1.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                adj2.add(new ArrayList<>());
            }
            for (int[] edge : edges1) {
                adj1.get(edge[0]).add(edge[1]);
                adj1.get(edge[1]).add(edge[0]);
            }
            for (int[] edge : edges2) {
                adj2.get(edge[0]).add(edge[1]);
                adj2.get(edge[1]).add(edge[0]);
            }

            // 计算第一棵树中每个节点在k步内可到达的节点数
            int[] map1 = new int[n];
            for (int i = 0; i < n; i++) {
                map1[i] = bfs(adj1, i, k, n);
            }
            // 计算第二棵树中每个节点在k-1步内可到达的节点数
            int[] map2 = new int[m];
            for (int j = 0; j < m; j++) {
                if (k - 1 >= 0) {
                    map2[j] = bfs(adj2, j, k - 1, m);
                } else {
                    map2[j] = 0;
                }
            }
            // 找到map2中的最大值
            int maxMap2 = 0;
            for (int count : map2) {
                if (count > maxMap2) {
                    maxMap2 = count;
                }
            }

            // 枚举map1每个值，加上第二棵树能到节点最多的数量，生成答案数组
            int[] answer = new int[n];
            for (int i = 0; i < n; i++) {
                answer[i] = map1[i] + maxMap2;
            }
            return answer;
        }

        // BFS函数，用于计算从start节点出发，最多steps步可到达的节点数
        private int bfs(List<List<Integer>> adj, int start, int steps, int size) {
            boolean[] visited = new boolean[size];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited[start] = true;
            int count = 1;
            int currentStep = 0;
            while (!queue.isEmpty() && currentStep < steps) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    int node = queue.poll();
                    for (int neighbor : adj.get(node)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                            count++;
                        }
                    }
                }
                currentStep++;
            }
            return count;
        }
    }

}
