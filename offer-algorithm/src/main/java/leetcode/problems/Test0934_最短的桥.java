package leetcode.problems;

public class Test0934_最短的桥 {

    public static void main(String[] args) {
        System.out.println(new Solution().shortestBridge(new int[][]{
                {0, 1},
                {1, 0},
        }));
        System.out.println(new Solution().shortestBridge(new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1},
        }));
        System.out.println(new Solution().shortestBridge(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        }));
        System.out.println(new Solution().shortestBridge(new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1},
        }));
        System.out.println(new Solution().shortestBridge(new int[][]{
                {0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0},
        }));
        System.out.println(new Solution().shortestBridge(new int[][]{
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
        }));
    }

    static class Solution {
        int height;
        int width;

        public int shortestBridge(int[][] grid) {
            height = grid.length;
            width = grid[0].length;
            markGrid(grid);
            for (int step = 0; step < width + height; step++) {
                int[][] expendGrids = expendGrids(grid, step);
                int cnt = getIslandCnt(expendGrids);
                if (cnt == 1) {
                    return step;
                }

            }
            return 0;
        }

        private void markGrid(int[][] grid) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 1) {
                        mark(grid, y, x);
                        return;
                    }
                }
            }
        }

        private void mark(int[][] grid, int y, int x) {
            if (y < 0 || y >= height || x < 0 || x >= width || grid[y][x] == 0 || grid[y][x] == 2) {
                return;
            }
            grid[y][x] = 2;
            mark(grid, y - 1, x);
            mark(grid, y + 1, x);
            mark(grid, y, x - 1);
            mark(grid, y, x + 1);
        }

        private int getIslandCnt(int[][] grid) {
            int cnt = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] != 0) {
                        deleteNeihbors(grid, y, x);
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        private void deleteNeihbors(int[][] newGrid, int y, int x) {
            if (y < 0 || y >= height || x < 0 || x >= width || newGrid[y][x] == 0) {
                return;
            }
            newGrid[y][x] = 0;
            deleteNeihbors(newGrid, y - 1, x);
            deleteNeihbors(newGrid, y + 1, x);
            deleteNeihbors(newGrid, y, x - 1);
            deleteNeihbors(newGrid, y, x + 1);
        }

        private int[][] expendGrids(int[][] grid, int step) {
            int[][] newGrid = new int[height][width];
            for (int y = 0; y < height; y++) {
                newGrid[y] = grid[y].clone();
            }
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (newGrid[y][x] == 2) {
                        dfs(newGrid, y, x, step + 1);
                    }
                }
            }
            return newGrid;
        }

        private void dfs(int[][] newGrid, int y, int x, int step) {
            if (step <= 0 || y < 0 || y >= height || x < 0 || x >= width) {
                return;
            }
            if (newGrid[y][x] == 0) {
                newGrid[y][x] = 3;
            }
            dfs(newGrid, y - 1, x, step - 1);
            dfs(newGrid, y + 1, x, step - 1);
            dfs(newGrid, y, x - 1, step - 1);
            dfs(newGrid, y, x + 1, step - 1);
        }
    }

}
