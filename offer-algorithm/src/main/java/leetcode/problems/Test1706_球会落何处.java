package leetcode.problems;

import java.util.Arrays;

public class Test1706_球会落何处 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findBall(new int[][]{
                {1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}
        })));
        System.out.println(Arrays.toString(new Solution().findBall(new int[][]{
                {-1}
        })));
        System.out.println(Arrays.toString(new Solution().findBall(new int[][]{
                {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}
        })));
    }

    static class Solution {
        public int[] findBall(int[][] grid) {
            int[] res = new int[grid[0].length];
            for (int x = 0; x < grid[0].length; x++) {
                dfs(0, x, grid, res, x);
            }
            return res;
        }

        private void dfs(int y, int x, int[][] grid, int[] res, int startX) {
            if (y > grid.length || x < 0 || x >= grid[0].length) {
                return;
            }
            if (y == grid.length) {
                res[startX] = x;
                return;
            }
            int dir = grid[y][x];
            if ((x == 0 && dir == -1) || (x == grid[0].length - 1 && dir == 1) || (dir != grid[y][x + dir])) {
                res[startX] = -1;
                return;
            }
            dfs(y + 1, x + dir, grid, res, startX);
        }
    }

    static class Solution_OLD {
        int[] res;
        int current;

        public int[] findBall(int[][] grid) {
            res = new int[grid[0].length];
            for (current = 0; current < grid[0].length; current++) {
                dfs(0, current, grid);
            }
            return res;
        }

        private void dfs(int y, int x, int[][] grid) {
            // 达到目的地
            if (y == grid.length) {
                res[current] = x;
                return;
            }
            if (y > grid.length || x < 0 || x >= grid[0].length) {
                return;
            }
            // 左边界无法再往左
            if (x == 0 && grid[y][x] == -1) {
                res[current] = -1;
                return;
            }
            // 右边界无法再往右
            if (x == grid[0].length - 1 && grid[y][x] == 1) {
                res[current] = -1;
                return;
            }
            // 想往左左边夹住
            if (grid[y][x] == -1 && x - 1 >= 0 && grid[y][x - 1] == 1) {
                res[current] = -1;
                return;
            }
            // 想往右左边夹住
            if (grid[y][x] == 1 && x + 1 < grid[0].length && grid[y][x + 1] == -1) {
                res[current] = -1;
                return;
            }
            // 继续向下走
            if (grid[y][x] == 1) {
                dfs(y + 1, x + 1, grid);
            } else if (grid[y][x] == -1) {
                dfs(y + 1, x - 1, grid);
            }
        }
    }

}
