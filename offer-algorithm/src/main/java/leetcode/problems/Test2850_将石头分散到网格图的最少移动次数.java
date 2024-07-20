package leetcode.problems;

import java.util.*;

public class Test2850_将石头分散到网格图的最少移动次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumMoves(new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {1, 2, 1}
        }));
        System.out.println(new Solution().minimumMoves(new int[][]{
                {1, 3, 0},
                {1, 0, 0},
                {1, 0, 3}
        }));
        System.out.println(new Solution().minimumMoves(new int[][]{
                {1, 2, 2},
                {1, 1, 0},
                {0, 1, 1}
        }));
        System.out.println(new Solution().minimumMoves(new int[][]{
                {3, 2, 0},
                {0, 1, 0},
                {0, 3, 0}
        }));
    }

    static class Solution {
        int res = Integer.MAX_VALUE;

        public int minimumMoves(int[][] grid) {
            // 只有3*3，考虑递归枚举
            dfs(grid, 0);
            return res;
        }

        private void dfs(int[][] grid, int step) {
            List<int[]> pos0 = new ArrayList<>();
            List<int[]> posn = new ArrayList<>();
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (grid[y][x] == 0) {
                        pos0.add(new int[]{y, x});
                    }
                    if (grid[y][x] > 1) {
                        posn.add(new int[]{y, x});
                    }
                }
            }
            if (pos0.isEmpty() && posn.isEmpty()) {
                res = Math.min(res, step);
                return;
            }
            for (int[] p0 : pos0) {
                for (int[] pn : posn) {
                    int y0 = p0[0];
                    int x0 = p0[1];
                    int yn = pn[0];
                    int xn = pn[1];
                    grid[y0][x0]++;
                    grid[yn][xn]--;
                    dfs(grid, step + Math.abs(y0 - yn) + Math.abs(x0 - xn));
                    grid[y0][x0]--;
                    grid[yn][xn]++;
                }
            }
        }
    }

    static class Solution_BFS错误 {
        public int minimumMoves(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int res = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // 从0点开始考虑最近的1，而不是从大于1的开始考虑最近的0
                    while (grid[y][x] == 0) {
                        res += bfs(y, x, grid);
                        grid[y][x]++;
                    }
                }
            }
            return res;
        }

        private int bfs(int y, int x, int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0},};
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{y, x, 0});
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentY = current[0];
                int currentX = current[1];
                int currentStep = current[2];
                if (grid[currentY][currentX] > 1) {
                    grid[currentY][currentX]--;
                    return currentStep;
                }
                for (int[] direction : directions) {
                    int nextY = currentY + direction[0];
                    int nextX = currentX + direction[1];
                    if (0 <= nextX && nextX < width && 0 <= nextY && nextY < height) {
                        queue.add(new int[]{nextY, nextX, currentStep + 1});
                    }
                }
            }
            return 0;
        }
    }

}
