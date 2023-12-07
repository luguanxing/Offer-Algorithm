package leetcode.problems;

import java.util.*;

public class Test1466_重新规划路线 {

    public static void main(String[] args) {
        // n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
        System.out.println(new Solution().minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
        // n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
        System.out.println(new Solution().minReorder(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}));
        // 3, [[1,2],[2,0]]
        System.out.println(new Solution().minReorder(3, new int[][]{{1, 2}, {2, 0}}));
        // 6, [[0,2],[0,3],[4,1],[4,5],[5,0]]
        System.out.println(new Solution().minReorder(6, new int[][]{{0, 2}, {0, 3}, {4, 1}, {4, 5}, {5, 0}}));
    }

    static class Solution {
        public int minReorder(int n, int[][] connections) {
            int cnt = 0;
            Map<Integer, List<Integer>> map = new HashMap<>();
            Set<Integer> visited = new HashSet<>();
            Set<String> connectionSet = new HashSet<>();
            for (int[] connection : connections) {
                int from = connection[0];
                int to = connection[1];
                connectionSet.add(from + "," + to);
                map.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
                map.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
            }
            // 从0开始统计反向边个数
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                visited.add(current);
                for (int next : map.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(next)) {
                        if (!connectionSet.contains(next + "," + current)) {
                            cnt++;
                        }
                        queue.add(next);
                    }
                }
            }
            return cnt;
        }
    }

}
