package leetcode.problems;

import java.util.*;

public class Test1377_T秒后青蛙的位置 {

    public static void main(String[] args) {
        System.out.println(new Solution().frogPosition(
                7,
                new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}},
                2,
                4
        ));
        System.out.println(new Solution().frogPosition(
                7,
                new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}},
                1,
                7
        ));
        System.out.println(new Solution().frogPosition(
                7,
                new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}},
                20,
                6
        ));
    }

    static class Solution {
        Map<Integer, List<Integer>> reachMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        double ans = 0;

        public double frogPosition(int n, int[][] edges, int t, int target) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                List<Integer> fromList = reachMap.getOrDefault(from, new ArrayList<>());
                fromList.add(to);
                reachMap.put(from, fromList);
                List<Integer> toList = reachMap.getOrDefault(to, new ArrayList<>());
                toList.add(from);
                reachMap.put(to, toList);
            }
            dfs(1, 1.0, t, target);
            return ans;
        }

        private void dfs(int currentNode, double currentPossibility, int leftTimes, int target) {
            if (currentNode == target && leftTimes == 0) {
                ans = currentPossibility;
                return;
            }
            if (leftTimes == 0) {
                return;
            }
            visited.add(currentNode);
            List<Integer> nexts = new ArrayList<>();
            for (int next : reachMap.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(next)) {
                    nexts.add(next);
                }
            }
            if (!nexts.isEmpty()) {
                for (int next : nexts) {
                    dfs(next, currentPossibility * (1.0 / nexts.size()), leftTimes - 1, target);
                }
            } else {
                dfs(currentNode, currentPossibility, leftTimes - 1, target);
            }
        }
    }

}
