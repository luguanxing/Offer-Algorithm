package leetcode.problems;

import java.util.*;

public class Test0743_网络延迟时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().networkDelayTime(
                new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2
        ));
        System.out.println(new Solution().networkDelayTime(
                new int[][]{{1, 2, 1}}, 2, 1
        ));
        System.out.println(new Solution().networkDelayTime(
                new int[][]{{1, 2, 1}}, 2, 2
        ));
        System.out.println(new Solution().networkDelayTime(
                new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1
        ));
        System.out.println(new Solution().networkDelayTime(
                new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1
        ));
    }

    static class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            // 构建邻接表
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] time : times) {
                graph.putIfAbsent(time[0], new ArrayList<>());
                graph.get(time[0]).add(new int[]{time[1], time[2]});
            }

            // Dijkstra找最短路径，初始化数组为无穷大
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[k] = 0; // 起点到自己的距离是 0

            // 优先队列存储 [距离, 节点]
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            pq.offer(new int[]{0, k}); // 起点入队

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int currDist = curr[0];
                int currNode = curr[1];

                // 如果当前距离大于已记录的最短距离，跳过
                if (currDist > dist[currNode]) continue;

                // 遍历邻接节点
                if (graph.containsKey(currNode)) {
                    for (int[] neighbor : graph.get(currNode)) {
                        int nextNode = neighbor[0];
                        int edgeWeight = neighbor[1];
                        int newDist = currDist + edgeWeight;

                        // 如果找到更短路径，更新并加入队列
                        if (newDist < dist[nextNode]) {
                            dist[nextNode] = newDist;
                            pq.offer(new int[]{newDist, nextNode});
                        }
                    }
                }
            }

            // 找到最远的最短路径
            int maxDist = Arrays.stream(dist).skip(1).max().getAsInt();
            return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
        }
    }

    static class Solution_OLD {
        public int networkDelayTime(int[][] times, int n, int k) {
            int[][] timeMap = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    timeMap[i][j] = Integer.MAX_VALUE / 2;
                }
            }
            for (int[] time : times) {
                int from = time[0];
                int to = time[1];
                int cost = time[2];
                timeMap[from][to] = cost;
                timeMap[from][from] = 0;
            }
            // prim算法，算出所有点到所有点最短
            for (int x = 1; x <= n; x++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (timeMap[i][j] > timeMap[i][x] + timeMap[x][j]) {
                            timeMap[i][j] = timeMap[i][x] + timeMap[x][j];
                        }
                    }
                }
            }
            // 判断k到是否能到剩余点和到最长耗时
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (timeMap[k][i] != Integer.MAX_VALUE / 2) {
                    count++;
                }
            }
            if (count == n) {
                return Arrays.stream(timeMap[k]).max().orElse(0);
            } else {
                return -1;
            }
        }
    }

}
