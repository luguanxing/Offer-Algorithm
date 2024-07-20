package leetcode.problems;

import java.util.*;

public class Test3112_访问消失节点的最少时间 {

    public static void main(String[] args) {
        // n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
        System.out.println(Arrays.toString(new Solution().minimumTime(
                3,
                new int[][]{{0, 1, 2}, {1, 2, 1}, {0, 2, 4}},
                new int[]{1, 1, 5}
        )));
        // n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,3,5]
        System.out.println(Arrays.toString(new Solution().minimumTime(
                3,
                new int[][]{{0, 1, 2}, {1, 2, 1}, {0, 2, 4}},
                new int[]{1, 3, 5}
        )));
        // n = 2, edges = [[0,1,1]], disappear = [1,1]
        System.out.println(Arrays.toString(new Solution().minimumTime(
                2,
                new int[][]{{0, 1, 1}},
                new int[]{1, 1}
        )));
    }

    static class Solution {
        public int[] minimumTime(int n, int[][] edges, int[] disappear) {
            // 建立邻接表表示图
            List<List<int[]>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int length = edge[2];
                graph.get(u).add(new int[]{v, length});
                graph.get(v).add(new int[]{u, length});
            }

            // 优先队列用于 Dijkstra 算法
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{0, 0});

            // 距离数组和访问数组
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[0] = 0;

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int node = current[0];
                int time = current[1];

                // 如果当前时间超过节点的消失时间，直接跳过
                if (time >= disappear[node]) continue;

                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int travelTime = neighbor[1];
                    int newTime = time + travelTime;

                    if (newTime < distances[nextNode] && newTime < disappear[nextNode]) {
                        distances[nextNode] = newTime;
                        pq.offer(new int[]{nextNode, newTime});
                    }
                }
            }

            // 构建答案数组
            int[] answer = new int[n];
            for (int i = 0; i < n; i++) {
                answer[i] = (distances[i] == Integer.MAX_VALUE) ? -1 : distances[i];
            }

            return answer;
        }
    }

}
