package leetcode.problems;

public class Test1219_黄金矿工 {

    public static void main(String[] args) {
        System.out.println(new Solution().getMaximumGold(new int[][]{
                {0, 6, 0}, {5, 8, 7}, {0, 9, 0}
        }));
        System.out.println(new Solution().getMaximumGold(new int[][]{
                {1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}
        }));
    }

    static class Solution {
        int max = 0;

        public int getMaximumGold(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            boolean[][] isVisited = new boolean[height][width];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // dfs + 回溯
                    dfs(grid, isVisited, y, x, 0);
                }
            }
            return max;
        }

        private void dfs(int[][] grid, boolean[][] isVisited, int y, int x, int current) {
            max = Math.max(max, current);
            if (y < 0 || grid.length <= y || x < 0 || grid[0].length <= x || grid[y][x] == 0 || isVisited[y][x]) {
                return;
            }
            isVisited[y][x] = true;
            dfs(grid, isVisited, y + 1, x, current + grid[y][x]);
            dfs(grid, isVisited, y - 1, x, current + grid[y][x]);
            dfs(grid, isVisited, y, x + 1, current + grid[y][x]);
            dfs(grid, isVisited, y, x - 1, current + grid[y][x]);
            isVisited[y][x] = false;
        }
    }

}
