package leetcode.problems;

import java.util.*;

public class Test1129_颜色交替的最短路径 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(
                3,
                new int[][]{{0, 1}, {1, 2}},
                new int[][]{}
        )));
        System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(
                3,
                new int[][]{{0, 1}},
                new int[][]{{2, 1}}
        )));
        System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(
                3,
                new int[][]{{1, 0}},
                new int[][]{{2, 1}}
        )));
        System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(
                3,
                new int[][]{{0, 1}},
                new int[][]{{1, 2}}
        )));
        System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(
                3,
                new int[][]{{0, 1}, {0, 2}},
                new int[][]{{1, 0}}
        )));
        System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(
                5,
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}},
                new int[][]{{1, 2}, {2, 3}, {3, 1}}
        )));
        System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(
                5,
                new int[][]{{2, 0}, {4, 3}, {4, 4}, {3, 0}, {1, 4}},
                new int[][]{{2, 1}, {4, 3}, {3, 1}, {3, 0}, {1, 1}, {2, 0}, {0, 3}, {3, 3}, {2, 3}}
        )));
    }

    static class Solution {
        Map<Integer, List<Integer>> rMap = new HashMap<>();
        Map<Integer, List<Integer>> bMap = new HashMap<>();

        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            for (int i = 0; i < n; i++) {
                rMap.put(i, new ArrayList<>());
                bMap.put(i, new ArrayList<>());
            }
            for (int[] redEdge : redEdges) {
                int from = redEdge[0];
                int to = redEdge[1];
                rMap.get(from).add(to);
            }
            for (int[] blueEdge : blueEdges) {
                int from = blueEdge[0];
                int to = blueEdge[1];
                bMap.get(from).add(to);
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = getPathLen(i);
            }
            return res;
        }

        private int getPathLen(int target) {
            int step = 0;
            Set<String> isVisited = new HashSet<>();
            Queue<int[]> queue = new ArrayDeque<>();
            isVisited.add("0-0");
            queue.add(new int[]{0, 0});
            while (!queue.isEmpty()) {
                List<int[]> currents = new ArrayList<>();
                while (!queue.isEmpty()) {
                    currents.add(queue.poll());
                }
                for (int[] current : currents) {
                    int point = current[0];
                    int color = current[1];
                    if (point == target) {
                        return step;
                    }
                    isVisited.add(point + "-" + color);
                    if (color == 0) {
                        for (int rNext : rMap.get(point)) {
                            if (!isVisited.contains(rNext + "-" + 1)) {
                                queue.add(new int[]{rNext, 1});
                            }
                        }
                        for (int bNext : bMap.get(point)) {
                            if (!isVisited.contains(bNext + "-" + 2)) {
                                queue.add(new int[]{bNext, 2});
                            }
                        }
                    } else if (color == 1) {
                        for (int bNext : bMap.get(point)) {
                            if (!isVisited.contains(bNext + "-" + 2)) {
                                queue.add(new int[]{bNext, 2});
                            }
                        }
                    } else if (color == 2) {
                        for (int rNext : rMap.get(point)) {
                            if (!isVisited.contains(rNext + "-" + 1)) {
                                queue.add(new int[]{rNext, 1});
                            }
                        }
                    }
                }
                step++;
            }
            return -1;
        }
    }
}
