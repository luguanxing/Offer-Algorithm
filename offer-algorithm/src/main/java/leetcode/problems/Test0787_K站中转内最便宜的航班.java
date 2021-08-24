package leetcode.problems;

import java.util.*;

public class Test0787_K站中转内最便宜的航班 {

    public static void main(String[] args) {
        System.out.println(new Solution().findCheapestPrice(
                3,
                new int[][]{
                        {0, 1, 100},
                        {1, 2, 100},
                        {0, 2, 500},
                },
                0,
                2,
                1
        ));
        System.out.println(new Solution().findCheapestPrice(
                3,
                new int[][]{
                        {0, 1, 100},
                        {1, 2, 100},
                        {0, 2, 500},
                },
                0,
                2,
                0
        ));
        System.out.println(new Solution().findCheapestPrice(
                5,
                new int[][]{{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}},
                0,
                2,
                2
        ));
    }

    static class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            Map<Integer, List<Integer>> reachMap = new HashMap<>();
            Map<String, Integer> priceMap = new HashMap<>();
            boolean[] visited = new boolean[n];
            int[] visiedPrice = new int[n];
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                List<Integer> list = reachMap.getOrDefault(from, new ArrayList<>());
                list.add(to);
                reachMap.put(from, list);
                priceMap.put(from + "," + to, price);
            }

            int res = Integer.MAX_VALUE;
            Queue<Stat> queue = new ArrayDeque<>();
            queue.add(new Stat(src, 0, 0));
            while (!queue.isEmpty()) {
                Stat stat = queue.poll();
                int currentPos = stat.currentPos;
                int costSteps = stat.costSteps;
                int costPrice = stat.costPrice;
                if (costSteps > k + 1) {
                    continue;
                }
                visited[currentPos] = true;
                visiedPrice[currentPos] = costPrice;
                if (currentPos == dst) {
                    res = Math.min(res, costPrice);
                }
                List<Integer> nextPosList = reachMap.getOrDefault(currentPos, new ArrayList<>());
                for (int nextPos : nextPosList) {
                    if (!visited[nextPos] || costPrice + priceMap.getOrDefault(currentPos + "," + nextPos, 0) < visiedPrice[nextPos]) {
                        queue.add(new Stat(nextPos,
                                costSteps + 1,
                                costPrice + priceMap.getOrDefault(currentPos + "," + nextPos, 0)
                        ));
                    }
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        class Stat {
            int currentPos;
            int costSteps;
            int costPrice;

            public Stat(int currentPos, int costSteps, int costPrice) {
                this.currentPos = currentPos;
                this.costSteps = costSteps;
                this.costPrice = costPrice;
            }
        }
    }

}
