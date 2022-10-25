package leetcode.problems;

import java.util.*;

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
            // 从一个岛走BFS到另一个岛，注意走前要摧毁
            Queue<int[]> queue = new ArrayDeque<>();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 2) {
                        grid[y][x] = 0;
                        queue.add(new int[]{y, x});
                    }
                }
            }
            int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            Set<String> set = new HashSet<>();
            int step = 0;
            while (!queue.isEmpty()) {
                List<int[]> list = new ArrayList<>();
                while (!queue.isEmpty()) {
                    int[] currentYX = queue.poll();
                    list.add(currentYX);
                    int currentY = currentYX[0];
                    int currentX = currentYX[1];
                    set.add(currentY + "," + currentX);
                    if (grid[currentY][currentX] == 1) {
                        return step - 1;
                    }
                }
                for (int[] currentYX : list) {
                    int currentY = currentYX[0];
                    int currentX = currentYX[1];
                    for (int[] direction : directions) {
                        int nextY = currentY + direction[0];
                        int nextX = currentX + direction[1];
                        if (0 <= nextY && nextY < height && 0 <= nextX && nextX < width && !set.contains(nextY + "," + nextX)) {
                            queue.add(new int[]{nextY, nextX});
                            set.add(nextY + "," + nextX);
                        }
                    }
                }
                step++;
            }
            return step;
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
    }

    static class Solution_暴力 {
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
