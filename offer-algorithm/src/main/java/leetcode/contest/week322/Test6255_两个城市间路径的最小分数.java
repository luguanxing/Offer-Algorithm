package leetcode.contest.week322;

import java.util.*;

public class Test6255_两个城市间路径的最小分数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minScore(
                4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}
        ));
        System.out.println(new Solution().minScore(
                4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}
        ));
        System.out.println(new Solution().minScore(
                36, new int[][]{{7, 11, 418}, {13, 23, 287}, {16, 25, 7891}, {15, 7, 9695}, {4, 3, 9569}, {17, 7, 1809}, {14, 3, 4720}, {14, 4, 6118}, {9, 2, 4290}, {32, 17, 5645}, {14, 16, 426}, {36, 7, 6721}, {13, 30, 9444}, {3, 25, 4635}, {33, 5, 1669}, {22, 18, 8910}, {5, 28, 7865}, {13, 10, 9466}, {7, 9, 2457}, {11, 8, 4711}, {17, 11, 6308}, {7, 34, 3789}, {8, 33, 9659}, {16, 3, 4187}, {16, 20, 3595}, {23, 10, 6251}, {26, 22, 6180}, {4, 16, 5577}, {26, 7, 5398}, {6, 36, 8671}, {10, 19, 3028}, {23, 30, 1330}, {19, 13, 8315}, {25, 20, 4740}, {25, 4, 5818}, {30, 10, 8030}, {30, 19, 7527}, {28, 6, 6804}, {21, 27, 1746}, {18, 9, 5189}, {7, 27, 6560}, {20, 14, 2450}, {27, 32, 3951}, {2, 21, 3927}, {1, 15, 9283}, {3, 20, 5428}, {15, 26, 5871}, {19, 23, 4533}, {14, 25, 6992}, {4, 20, 5831}}
        ));
    }

    static class Solution {
        Map<Integer, List<int[]>> reachMap;
        int[] cost;

        public int minScore(int n, int[][] roads) {
            reachMap = new HashMap<>();
            cost = new int[n + 1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            // init map
            for (int[] road : roads) {
                int from = road[0];
                int to = road[1];
                int cost = road[2];
                List<int[]> list1 = reachMap.getOrDefault(from, new ArrayList<>());
                int[] toAndCost = new int[]{to, cost};
                list1.add(toAndCost);
                reachMap.put(from, list1);
                List<int[]> list2 = reachMap.getOrDefault(to, new ArrayList<>());
                int[] fromAndCost = new int[]{from, cost};
                list2.add(fromAndCost);
                reachMap.put(to, list2);
            }
            // dfs(1)
            dfs(1, 100005);
            return Arrays.stream(cost).min().getAsInt();
        }

        private void dfs(int node, int currentCost) {
            if (currentCost < cost[node]) {
                cost[node] = currentCost;
            } else {
                return;
            }
            for (int[] next : reachMap.get(node)) {
                int to = next[0];
                int cost = next[1];
                dfs(to, Math.min(cost, currentCost));
            }
        }
    }

    static class Solution_猜想失败 {
        public int minScore(int n, int[][] roads) {
            // 有可能1不到2,3节点，但2,3节点最短
            int min = Integer.MAX_VALUE;
            for (int[] road : roads) {
                min = Math.min(min, road[2]);
            }
            return min;
        }
    }

}
