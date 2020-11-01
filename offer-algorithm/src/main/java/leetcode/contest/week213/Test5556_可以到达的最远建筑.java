package leetcode.contest.week213;

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
    }

    static class Solution {
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
