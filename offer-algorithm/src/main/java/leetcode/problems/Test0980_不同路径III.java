package leetcode.problems;

public class Test0980_不同路径III {

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        }));
        System.out.println(new Solution().uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        }));
    }

    static class Solution {
        int totalSteps = 0;
        int ans = 0;

        public int uniquePathsIII(int[][] grid) {
            for (int[] row : grid) {
                for (int v : row) {
                    if (v == 0) {
                        totalSteps++;
                    }
                }
            }
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[0].length; x++) {
                    if (grid[y][x] == 1) {
                        dfs(grid, y, x, 0);
                    }
                }
            }
            return ans;
        }

        private void dfs(int[][] grid, int y, int x, int step) {
            int height = grid.length;
            int width = grid[0].length;
            if (y < 0 || y >= height || x < 0 || x >= width || grid[y][x] == -1) {
                return;
            }
            if (grid[y][x] == 2) {
                if (step - 1 == totalSteps) {
                    ans++;
                }
                return;
            }
            grid[y][x] = -1;
            dfs(grid, y - 1, x, step + 1);
            dfs(grid, y + 1, x, step + 1);
            dfs(grid, y, x - 1, step + 1);
            dfs(grid, y, x + 1, step + 1);
            grid[y][x] = 0;
        }
    }

}
