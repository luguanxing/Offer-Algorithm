package leetcode.contest.week213;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test5556_可以到达的最远建筑 {

    public static void main(String[] args) {
        System.out.println(new Solution().furthestBuilding(
                new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1
        ));
        System.out.println(new Solution().furthestBuilding(
                new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2
        ));
        System.out.println(new Solution().furthestBuilding(
                new int[]{14, 3, 19, 3}, 17, 0
        ));
        System.out.println(new Solution().furthestBuilding(
                new int[]{1, 5, 6, 7, 8}, 4, 1
        ));
        System.out.println(new Solution().furthestBuilding(
                new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1
        ));
    }

    static class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> diffs = new PriorityQueue<>(Comparator.naturalOrder());
            int currentBricks = 0;
            for (int i = 1; i < heights.length; i++) {
                int diff = heights[i] - heights[i - 1];
                if (diff <= 0) {
                    continue;
                }
                diffs.add(diff);
                if (diffs.size() > ladders) {
                    currentBricks += diffs.poll();
                }
                if (currentBricks > bricks) {
                    return i - 1;
                }
            }
            return heights.length - 1;
        }
    }

    static class Solution_错误 {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            for (int i = 0; i < heights.length - 1; i++) {
                int current = heights[i];
                int next = heights[i + 1];
                if (current >= next) {
                    continue;
                }
                if (current + bricks >= next) {
                    bricks -= next - current;
                    continue;
                }
                if (ladders > 0) {
                    ladders--;
                    continue;
                }
                return i;
            }
            return heights.length - 1;
        }
    }

}
