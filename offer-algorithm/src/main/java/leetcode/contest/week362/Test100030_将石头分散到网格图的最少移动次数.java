package leetcode.contest.week362;

import java.util.*;

public class Test100030_将石头分散到网格图的最少移动次数 {

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
    }

    static class Solution {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int minimumMoves(int[][] grid) {
            Queue<StateNode> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.offer(new StateNode(grid, 0));
            while (!queue.isEmpty()) {
                // 当前局面
                StateNode current = queue.poll();
                if (isTarget(current.grid)) {
                    return current.moves;
                }
                // 找出石头大于1的上下左右移动
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (current.grid[i][j] > 1) {
                            for (int[] dir : directions) {
                                int x = i + dir[0];
                                int y = j + dir[1];
                                if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                                    int[][] newGrid = cloneGrid(current.grid);
                                    newGrid[i][j]--;
                                    newGrid[x][y]++;
                                    String gridStr = gridToString(newGrid);
                                    // 局面去重
                                    if (!visited.contains(gridStr)) {
                                        visited.add(gridStr);
                                        queue.offer(new StateNode(newGrid, current.moves + 1));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // 不可能达到目标状态
            return -1;
        }

        private boolean isTarget(int[][] grid) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] != 1) return false;
                }
            }
            return true;
        }

        private int[][] cloneGrid(int[][] grid) {
            int[][] newGrid = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    newGrid[i][j] = grid[i][j];
                }
            }
            return newGrid;
        }

        private String gridToString(int[][] grid) {
            String res = "";
            for (int i = 0; i < 3; i++) {
                res += Arrays.toString(grid[i]);
            }
            return res;
        }


        class StateNode {
            int[][] grid;
            int moves;

            StateNode(int[][] grid, int moves) {
                this.grid = grid;
                this.moves = moves;
            }
        }
    }

}
