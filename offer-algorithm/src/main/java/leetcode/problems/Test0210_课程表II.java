package leetcode.problems;

import java.util.*;

public class Test0210_课程表II {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{})));
        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{{0, 1}})));
        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{{1, 0}, {0, 1}})));
        System.out.println(Arrays.toString(new Solution().findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}})));
        System.out.println(Arrays.toString(new Solution().findOrder(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {3, 0}})));
        System.out.println(Arrays.toString(new Solution().findOrder(3, new int[][]{{0, 2}, {1, 2}, {2, 0}})));
        System.out.println(Arrays.toString(new Solution().findOrder(5, new int[][]{{3, 1}, {3, 2}, {1, 4}, {2, 4}})));
        System.out.println(Arrays.toString(new Solution().findOrder(8, new int[][]{{1, 0}, {1, 7}, {7, 0}, {0, 5}, {2, 6}, {6, 4}})));
    }

    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer> order = new ArrayList<>();
            Map<Integer, List<Integer>> reachMap = new HashMap<>();
            // 拓补排序，统计入度
            int[] inDegree = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                int to = prerequisite[0];
                int from = prerequisite[1];
                List<Integer> list = reachMap.getOrDefault(from, new ArrayList<>());
                list.add(to);
                reachMap.put(from, list);
                inDegree[to]++;
            }
            // 从入度为0的点开始BFS
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    deque.add(i);
                }
            }
            while (!deque.isEmpty()) {
                int current = deque.poll();
                order.add(current);
                for (int next : reachMap.getOrDefault(current, new ArrayList<>())) {
                    if (inDegree[next] > 0) {
                        inDegree[next]--;
                        if (inDegree[next] == 0) {
                            deque.add(next);
                        }
                    }
                }
            }
            if (Arrays.stream(inDegree).sum() != 0) {
                return new int[]{};
            }
            int[] res = new int[order.size()];
            for (int i = 0; i < order.size(); i++) {
                res[i] = order.get(i);
            }
            return res;
        }
    }

}
