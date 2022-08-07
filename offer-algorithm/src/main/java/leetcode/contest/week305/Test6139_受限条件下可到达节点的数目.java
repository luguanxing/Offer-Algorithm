package leetcode.contest.week305;

import java.util.*;

public class Test6139_受限条件下可到达节点的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().reachableNodes(
                7,
                new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}},
                new int[]{4, 5}
        ));
        System.out.println(new Solution().reachableNodes(
                7,
                new int[][]{{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}},
                new int[]{4, 2, 1}
        ));
    }

    static class Solution {
        Map<Integer, List<Integer>> canGoMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> banned = new HashSet<>();

        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            for (int[] edge : edges) {
                int src = edge[0];
                int dst = edge[1];
                List<Integer> srcCanGo = canGoMap.getOrDefault(src, new ArrayList<>());
                srcCanGo.add(dst);
                canGoMap.put(src, srcCanGo);
                List<Integer> dstCanGo = canGoMap.getOrDefault(dst, new ArrayList<>());
                dstCanGo.add(src);
                canGoMap.put(dst, dstCanGo);
            }
            for (int r : restricted) {
                banned.add(r);
            }
            int res = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(0);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                visited.add(current);
                res++;
                List<Integer> nexts = canGoMap.getOrDefault(current, new ArrayList<>());
                for (int next : nexts) {
                    if (!visited.contains(next) && !banned.contains(next)) {
                        queue.add(next);
                    }
                }
            }
            return res;
        }
    }

}
