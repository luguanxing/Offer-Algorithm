package leetcode.problems;

public class Test1254_统计封闭岛屿的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().closedIsland(
                new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0},
                        {1, 0, 1, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0}
                }
        ));
        System.out.println(new Solution().closedIsland(
                new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 1, 0, 1, 0},
                        {0, 1, 1, 1, 0}
                }
        ));
        System.out.println(new Solution().closedIsland(
                new int[][]{
                        {1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1}
                }
        ));
    }

    static class Solution {
        public int closedIsland(int[][] grid) {
            int cnt = 0;
            int height = grid.length;
            int width = grid[0].length;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 0 && dfs(grid, y, x)) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        private boolean dfs(int[][] grid, int y, int x) {
            int height = grid.length;
            int width = grid[0].length;
            if (y < 0 || y >= height || x < 0 || x >= width) {
                return false;
            }
            if (grid[y][x] == 1) {
                return true;
            }
            grid[y][x] = 1;
            boolean up = dfs(grid, y - 1, x);
            boolean down = dfs(grid, y + 1, x);
            boolean left = dfs(grid, y, x - 1);
            boolean right = dfs(grid, y, x + 1);
            return up && down && left && right;
        }
    }

}
