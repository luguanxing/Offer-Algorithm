package leetcode.contest.week343;

import java.util.*;

public class Test6343_前往目标的最小代价 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumCost(
                new int[]{1, 1},
                new int[]{4, 5},
                new int[][]{
                        {1, 2, 3, 3, 2},
                        {3, 4, 4, 5, 1},
                }
        ));
        System.out.println(new Solution().minimumCost(
                new int[]{3, 2},
                new int[]{5, 7},
                new int[][]{
                        {3, 2, 3, 4, 4},
                        {3, 3, 5, 5, 5},
                        {3, 4, 5, 6, 6},
                }
        ));
    }

    static class Solution {
        public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
            int x1 = start[0];
            int y1 = start[1];
            int x2 = target[0];
            int y2 = target[1];
            int cost1 = Math.abs(x1 - x2) + Math.abs(y1 - y2);
            int cost2 = Integer.MAX_VALUE;
            for (int[] road : specialRoads) {
                int xa = road[0];
                int ya = road[1];
                int xb = road[2];
                int yb = road[3];
                int cost = road[4];
                if (Math.abs(x1 - xa) + Math.abs(y1 - ya) + Math.abs(x2 - xb) + Math.abs(y2 - yb) + cost > cost1) {
                    continue;
                }
                int currentCost = cost
                        + minimumCost(new int[]{x1, y1}, new int[]{xa, ya}, specialRoads)
                        + minimumCost(new int[]{xb, yb}, new int[]{x2, y2}, specialRoads);
                cost2 = Math.min(cost2, currentCost);
            }
            return Math.min(cost1, cost2);
        }
    }

}
