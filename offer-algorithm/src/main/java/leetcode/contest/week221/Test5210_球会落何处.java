package leetcode.contest.week221;

import java.util.Arrays;

public class Test5210_球会落何处 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findBall(
                new int[][]{
                        {1, 1, 1, -1, -1},
                        {1, 1, 1, -1, -1},
                        {-1, -1, -1, 1, 1},
                        {1, 1, 1, 1, -1},
                        {-1, -1, -1, -1, -1}
                }
        )));
        System.out.println(Arrays.toString(new Solution().findBall(
                new int[][]{
                        {-1}
                }
        )));
    }

    static class Solution {
        public int[] findBall(int[][] grid) {
            int[] res = new int[grid[0].length];
            for (int x = 0; x < grid[0].length; x++) {
                res[x] = check(0, x, grid);
            }
            return res;
        }

        private int check(int y, int x, int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            if (y >= height) {
                return 1;
            }
            if (grid[y][x] == 1) {
                // 当前向右滚
                if (x == width - 1) {
                    return -1;
                }
                if (grid[y][x + 1] == -1) {
                    return -1;
                }
                return check(y + 1, x + 1, grid);
            } else {
                // 当前向左滚
                if (x == 0) {
                    return -1;
                }
                if (grid[y][x - 1] == 1) {
                    return -1;
                }
                return check(y + 1, x - 1, grid);
            }
        }
    }

}
