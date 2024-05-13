package leetcode.problems;

import java.util.*;

public class Test0994_腐烂的橘子 {

    public static void main(String[] args) {
        // grid = [[2,1,1],[1,1,0],[0,1,1]]
        System.out.println(new Solution().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        // grid = [[2,1,1],[0,1,1],[1,0,1]]
        System.out.println(new Solution().orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        // grid = [[0,2]]
        System.out.println(new Solution().orangesRotting(new int[][]{{0, 2}}));
    }

    static class Solution {
        public int orangesRotting(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int fresh = 0;
            Queue<int[]> queue = new ArrayDeque<>();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 2) {
                        queue.add(new int[]{y, x});
                    }
                    if (grid[y][x] == 1) {
                        fresh++;
                    }
                }
            }
            int res = 0;
            while (!queue.isEmpty()) {
                List<int[]> currents = new ArrayList<>(queue);
                queue.clear();
                for (int[] current : currents) {
                    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                    for (int[] direction : directions) {
                        int y = current[0] + direction[0];
                        int x = current[1] + direction[1];
                        if (y >= 0 && y < height && x >= 0 && x < width && grid[y][x] == 1) {
                            queue.add(new int[]{y, x});
                            grid[y][x] = 2;
                            fresh--;
                        }
                    }
                }
                if (!queue.isEmpty()) {
                    res++;
                }
            }
            return fresh == 0 ? res : -1;
        }
    }

}
