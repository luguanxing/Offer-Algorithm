package leetcode.contest.week346;

import java.util.*;

public class Test6442_修改图中的边权 {

    public static void main(String[] args) {
        int[][] res = new Solution().modifiedGraphEdges(
                4,
                new int[][]{{0, 1, -1}, {1, 2, -1}, {3, 1, -1}, {3, 0, 2}, {0, 2, 5}},
                2,
                3,
                8
        );
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    static class Solution {
        Map<Integer, List<int[]>> map = new HashMap<>();
        List<List<int[]>> paths = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        boolean isOk = false;

        public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
            // 初始化地图
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int cost = edge[2];
                List<int[]> fromList = map.getOrDefault(from, new ArrayList<>());
                fromList.add(new int[]{to, cost});
                map.put(from, fromList);
                List<int[]> toList = map.getOrDefault(to, new ArrayList<>());
                toList.add(new int[]{from, cost});
                map.put(to, toList);
            }
            // 找出所有路径
            getAllPath(source, destination, new ArrayList<>());
            List<int[]> bestPath = null;
            // 最短路径
            int bfsLen = bfs(source, destination) - 1;
            // 判断所有路径
            for (List<int[]> path : paths) {
                int negCnt = 0;
                int sum = 0;
                for (int[] p : path) {
                    int point = p[0];
                    int cost = p[1];
                    if (cost == -1) {
                        negCnt++;
                        sum += 0;
                    } else {
                        sum += cost;
                    }
                }
                if (sum == target && negCnt == 0) {
                    return edges;
                }
                if (sum > target || (sum < target && negCnt == 0) || sum + negCnt > target) {
                    continue;
                }
                // 可通过修改-1的情况
                if (bestPath == null || bestPath.size() > path.size()) {
                    bestPath = path;
                }
                isOk = true;
            }
            if (!isOk || bestPath.size() != bfsLen) {
                return new int[][]{};
            }
            int negCnt = 0;
            int sum = 0;
            for (int[] p : bestPath) {
                int point = p[0];
                int cost = p[1];
                if (cost == -1) {
                    negCnt++;
                    sum += 0;
                } else {
                    sum += cost;
                }
            }
            int diff = target - sum;
            List<Integer> points = new ArrayList<>();
            points.add(source);
            for (int[] p : bestPath) {
                points.add(p[0]);
            }
            for (int i = 1; i < points.size(); i++) {
                int from = points.get(i - 1);
                int to = points.get(i);
                int cost = bestPath.get(i - 1)[1];
                if (cost == -1) {
                    int newCost = (negCnt > 1 ? 1 : diff);
                    negCnt--;
                    diff -= newCost;
                    for (int[] edge : edges) {
                        if ((edge[0] == from && edge[1] == to) || (edge[1] == from && edge[0] == to)) {
                            edge[2] = newCost;
                        }
                    }
                }
            }
            // 处理无关边
            for (int[] edge : edges) {
                if (edge[2] == -1) {
                    edge[2] = 1;
                }
            }
            System.out.println("bfs=" + bfsLen);
            return edges;
        }

        private int bfs(int source, int destination) {
            int len = 0;
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> q = new ArrayDeque<>();
            q.add(source);
            visited.add(source);
            while (!q.isEmpty()) {
                List<Integer> currents = new ArrayList<>();
                while (!q.isEmpty()) {
                    currents.add(q.poll());
                }
                len++;
                for (int current : currents) {
                    if (current == destination) {
                        return len;
                    }
                    for (int[] nextt : map.getOrDefault(current, new ArrayList<>())) {
                        int next = nextt[0];
                        if (!visited.contains(next)) {
                            q.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            return len;
        }

        private void getAllPath(int current, int destination, List<int[]> currentPath) {
            if (current == destination) {
                paths.add(new ArrayList<>(currentPath));
                return;
            }
            visited.add(current);
            for (int[] nextAndCosts : map.getOrDefault(current, new ArrayList<>())) {
                int next = nextAndCosts[0];
                int cost = nextAndCosts[1];
                if (!visited.contains(next)) {
                    currentPath.add(new int[]{next, cost});
                    getAllPath(next, destination, currentPath);
                    currentPath.remove(currentPath.size() - 1);
                }
            }
            visited.remove(current);
        }
    }

}
