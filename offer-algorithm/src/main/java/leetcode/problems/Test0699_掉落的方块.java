package leetcode.problems;

import java.util.*;

public class Test0699_掉落的方块 {

    public static void main(String[] args) {
        // positions = [[1,2],[2,3],[6,1]]
        System.out.println(new Solution().fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
        // positions = [[100,100],[200,100]]
        System.out.println(new Solution().fallingSquares(new int[][]{{100, 100}, {200, 100}}));
    }

    static class Solution {
        public List<Integer> fallingSquares(int[][] positions) {
            // 枚举每个方块掉落时下面重叠的方块，取最高的
            int len = positions.length;
            List<Integer> heights = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                int[] position = positions[i];
                int left = position[0];
                int side = position[1];
                int right = left + side - 1;
                int height = side;
                for (int j = 0; j < i; j++) {
                    // 枚举现有的下面方块，找最高能重叠的放上去
                    int l = positions[j][0];
                    int s = positions[j][1];
                    int r = l + s - 1;
                    int h = heights.get(j);
                    if (left <= r && l <= right) {
                        height = Math.max(height, h + side);
                    }
                }
                heights.add(height);
            }
            for (int i = 1; i < len; i++) {
                heights.set(i, Math.max(heights.get(i), heights.get(i - 1)));
            }
            return heights;
        }
    }

}
