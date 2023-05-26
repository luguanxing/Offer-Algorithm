package leetcode.problems;

import java.util.*;

public class Test1091_二进制矩阵中的最短路径 {

    public static void main(String[] args) {
        System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
    }

    static class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            if (grid[0][0] != 0) {
                return -1;
            }
            int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            Queue<int[]> queue = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();
            queue.add(new int[]{0, 0});
            visited.add("0,0");
            int step = 0;
            while (!queue.isEmpty()) {
                List<int[]> currents = new ArrayList<>(queue);
                queue.clear();
                step++;
                for (int[] current : currents) {
                    int y = current[0];
                    int x = current[1];
                    if (y == height - 1 && x == width - 1) {
                        return step;
                    }
                    for (int[] direction : directions) {
                        int nextY = y + direction[0];
                        int nextX = x + direction[1];
                        if (
                                0 <= nextY && nextY < height &&
                                        0 <= nextX && nextX < width &&
                                        grid[nextY][nextX] == 0 &&
                                        !visited.contains(nextY + "," + nextX)
                        ) {
                            visited.add(nextY + "," + nextX);
                            queue.add(new int[]{nextY, nextX});
                        }
                    }
                }
            }
            return -1;
        }
    }

}
