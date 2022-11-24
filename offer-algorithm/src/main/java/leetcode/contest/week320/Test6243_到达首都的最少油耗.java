package leetcode.contest.week320;

import java.util.*;

public class Test6243_到达首都的最少油耗 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumFuelCost(
                new int[][]{{0, 1}, {0, 2}, {0, 3}}, 5
        ));
        System.out.println(new Solution().minimumFuelCost(
                new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2
        ));
        System.out.println(new Solution().minimumFuelCost(
                new int[][]{}, 1
        ));
    }

    static class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        long res = 0;

        public long minimumFuelCost(int[][] roads, int seats) {
            // 构建map
            for (int[] road : roads) {
                int from = road[0];
                int to = road[1];
                List<Integer> list1 = map.getOrDefault(from, new ArrayList<>());
                list1.add(to);
                map.put(from, list1);
                List<Integer> list2 = map.getOrDefault(to, new ArrayList<>());
                list2.add(from);
                map.put(to, list2);
            }
            // 对于某个节点cur，如果它有size个子节点，
            // 那么这size个节点到达cur父节点时，因为只有一条路来往，所有耗油量为(size+seats-1)/seats。
            getNodesCnt(0, seats);
            return res;
        }

        // DFS，计算以每个节点为根节点的子树节点数目，同时将其子节点到该节点的耗油量算入总量中
        private int getNodesCnt(int current, int seats) {
            visited.add(current);
            int totalCnt = 1;
            if (!map.containsKey(current)) {
                return 0;
            }
            for (int next : map.get(current)) {
                if (visited.contains(next)) {
                    continue;
                }
                int nodesCnt = getNodesCnt(next, seats);
                res += (nodesCnt + seats - 1) / seats;
                totalCnt += nodesCnt;
            }
            return totalCnt;
        }
    }

}
