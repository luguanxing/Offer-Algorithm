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
            // DFS，计算以每个节点为根节点的子树节点数目。
            // 对于某个节点cur，如果它的某个子树next有size个节点，
            // 那么这size个节点的城市代表汇聚到节点cur一起前往cur父节点时，耗油量为(size+seats-1)/seats。
            // 按照这个思路计算城市代表到达各个节点的油耗，最后返回0城市的油耗即可
            visited.add(0);
            if (!map.containsKey(0)) {
                return 0;
            }
            for (int node : map.get(0)) {
                int nodesCnt = getNodesCnt(node, seats);
                res += (nodesCnt + seats - 1) / seats;
            }
            return res;
        }

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
