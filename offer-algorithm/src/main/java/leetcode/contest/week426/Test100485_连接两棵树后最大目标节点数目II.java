package leetcode.contest.week426;

import java.util.*;

public class Test100485_连接两棵树后最大目标节点数目II {

    public static void main(String[] args) {
        // edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]
        System.out.println(Arrays.toString(new Solution().maxTargetNodes(new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}}, new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}})));
        // edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]]
        System.out.println(Arrays.toString(new Solution().maxTargetNodes(new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}}, new int[][]{{0, 1}, {1, 2}, {2, 3}})));
    }

    static class Solution {
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
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

            // 对树进行二分染色并统计颜色数量
            int[] color1 = new int[n];
            int[] count1 = new int[2];
            int[] color2 = new int[m];
            int[] count2 = new int[2];
            Arrays.fill(color1, -1);
            Arrays.fill(color2, -1);
            bfsColoring(adj1, color1, count1);
            bfsColoring(adj2, color2, count2);

            // 生成答案数组
            int[] answer = new int[n];
            for (int i = 0; i < n; i++) {
                // 第一个节点的同色 + 第二个节点的最多色（无须选择异色，因为通过选择另一个颜色可以实现获取）
                answer[i] = count1[color1[i]] +  Math.max(count2[0], count2[1]);
            }
            return answer;
        }

        private void bfsColoring(List<List<Integer>> adj, int[] color, int[] count) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            color[0] = 0;
            count[0]++;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int neighbor : adj.get(current)) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[current];
                        count[color[neighbor]]++;
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }

}
