package leetcode.problems;

import java.util.*;

public class Test1042_不邻接植花 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().gardenNoAdj(
                3,
                new int[][]{{1, 2}, {2, 3}, {3, 1}}
        )));
        System.out.println(Arrays.toString(new Solution().gardenNoAdj(
                4,
                new int[][]{{1, 2}, {3, 4}}
        )));
        System.out.println(Arrays.toString(new Solution().gardenNoAdj(
                4,
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}}
        )));
        System.out.println(Arrays.toString(new Solution().gardenNoAdj(
                1,
                new int[][]{}
        )));
    }

    static class Solution {
        public int[] gardenNoAdj(int n, int[][] paths) {
            Map<Integer, List<Integer>> reachMap = new HashMap<>();
            for (int[] path : paths) {
                int from = path[0];
                int to = path[1];
                List<Integer> fromList = reachMap.getOrDefault(from, new ArrayList<>());
                fromList.add(to);
                reachMap.put(from, fromList);
                List<Integer> toList = reachMap.getOrDefault(to, new ArrayList<>());
                toList.add(from);
                reachMap.put(to, toList);
            }
            // 从1-n逐个染色
            int[] colors = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                paint(i, colors, reachMap);
            }
            return Arrays.copyOfRange(colors, 1, n + 1);
        }

        private void paint(int idx, int[] colors, Map<Integer, List<Integer>> reachMap) {
            // 之前染过色则放弃
            if (colors[idx] != 0) {
                return;
            }
            // BFS，每次从判断相邻的color，从剩下的选
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(idx);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (colors[current] != 0) {
                    continue;
                }
                List<Integer> neighbors = reachMap.getOrDefault(current, new ArrayList<>());
                Set<Integer> invalidColorSet = new HashSet<>();
                for (int neighbor : neighbors) {
                    invalidColorSet.add(colors[neighbor]);
                    if (colors[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
                for (int color = 1; color <= 4; color++) {
                    if (!invalidColorSet.contains(color)) {
                        colors[current] = color;
                        break;
                    }
                }
            }
        }
    }

}
