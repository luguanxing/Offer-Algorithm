package leetcode.problems;

public class Test1020_飞地的数量 {

    public static void main(String[] args) {

    }

    static class Solution {
        boolean[][] isVisited;

        public int numEnclaves(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            isVisited = new boolean[height][width];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 1 && (y == 0 || y == height - 1 || x == 0 || x == width - 1)) {
                        dfs(grid, y, x);
                    }
                }
            }

            int res = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 1 && !isVisited[y][x]) {
                        res++;
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] grid, int y, int x) {
            if (y < 0 || grid.length <= y || x < 0 || grid[0].length <= x || isVisited[y][x] || grid[y][x] == 0) {
                return;
            }
            isVisited[y][x] = true;
            dfs(grid, y - 1, x);
            dfs(grid, y + 1, x);
            dfs(grid, y, x - 1);
            dfs(grid, y, x + 1);
        }
    }

}
