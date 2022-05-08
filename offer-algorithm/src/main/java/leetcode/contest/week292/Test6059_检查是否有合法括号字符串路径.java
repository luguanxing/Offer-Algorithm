package leetcode.contest.week292;

import java.util.*;

public class Test6059_检查是否有合法括号字符串路径 {

    public static void main(String[] args) {
        System.out.println(new Solution().hasValidPath(new char[][]{{'(', '(', '('}, {')', '(', ')'}, {'(', '(', ')'}, {'(', '(', ')'}}));
        System.out.println(new Solution().hasValidPath(new char[][]{{')', ')'}, {'(', '('}}));
        System.out.println(new Solution().hasValidPath(new char[][]{{'(', ')', ')', '(', '(', '(', '(', ')', ')', '(', ')', '(', ')', '(', '(', '(', '(', ')', '(', ')', '('}, {'(', '(', ')', ')', '(', ')', ')', ')', '(', ')', '(', ')', '(', '(', ')', '(', '(', '(', '(', '(', ')'}, {')', ')', '(', ')', ')', '(', '(', ')', '(', '(', ')', '(', ')', ')', '(', ')', ')', '(', '(', ')', ')'}, {'(', '(', ')', '(', ')', '(', ')', ')', ')', '(', ')', '(', '(', ')', '(', ')', ')', '(', ')', ')', ')'}, {'(', '(', '(', ')', '(', '(', ')', '(', ')', ')', '(', ')', ')', ')', ')', ')', ')', '(', ')', '(', '('}, {')', ')', '(', '(', ')', ')', ')', ')', ')', '(', ')', ')', ')', '(', '(', ')', '(', '(', '(', '(', ')'}, {')', ')', ')', ')', '(', ')', '(', ')', '(', '(', ')', '(', '(', ')', '(', '(', ')', ')', '(', ')', '('}, {'(', ')', '(', '(', '(', ')', ')', ')', ')', '(', '(', ')', '(', '(', ')', ')', '(', ')', ')', ')', '('}, {'(', ')', '(', ')', '(', '(', '(', '(', ')', '(', '(', '(', '(', '(', '(', ')', '(', ')', '(', ')', ')'}, {'(', ')', '(', '(', '(', ')', '(', ')', ')', ')', ')', '(', '(', '(', '(', ')', ')', '(', '(', '(', ')'}, {'(', '(', ')', '(', ')', ')', '(', ')', '(', ')', ')', ')', ')', ')', '(', ')', '(', ')', ')', ')', '('}, {')', '(', '(', '(', ')', '(', ')', ')', '(', ')', '(', ')', '(', '(', ')', '(', '(', ')', '(', '(', ')'}, {'(', ')', '(', ')', ')', '(', '(', ')', '(', ')', '(', ')', ')', ')', '(', '(', '(', '(', ')', '(', ')'}, {'(', '(', ')', '(', ')', ')', '(', '(', '(', ')', '(', ')', '(', '(', ')', ')', '(', '(', '(', ')', ')'}, {'(', '(', '(', '(', ')', ')', '(', ')', '(', '(', '(', ')', ')', '(', ')', '(', ')', ')', ')', ')', '('}, {'(', '(', '(', ')', ')', ')', '(', ')', ')', '(', ')', ')', '(', '(', ')', '(', ')', '(', '(', '(', ')'}, {')', ')', ')', ')', ')', ')', '(', ')', ')', ')', '(', '(', ')', '(', ')', '(', '(', '(', '(', ')', ')'}}));
        System.out.println(new Solution().hasValidPath(new char[][]{{'(', '(', '(', '(', '(', ')', ')', '(', ')', ')', '(', ')', ')', '(', ')', '(', '(', ')', ')', '(', ')', '(', ')', ')', '(', ')', ')', ')', ')', '(', ')', '(', '('}, {'(', ')', ')', '(', '(', ')', ')', ')', ')', '(', ')', '(', ')', '(', ')', '(', '(', ')', ')', '(', '(', '(', '(', ')', ')', ')', ')', ')', '(', '(', ')', '(', '('}, {')', ')', '(', '(', ')', ')', ')', ')', '(', ')', '(', ')', ')', ')', '(', '(', ')', '(', ')', '(', '(', '(', ')', ')', ')', ')', ')', ')', ')', ')', ')', '(', '('}, {'(', '(', '(', ')', '(', ')', ')', ')', '(', ')', '(', '(', '(', ')', '(', ')', '(', ')', '(', ')', '(', ')', '(', ')', ')', ')', '(', '(', ')', '(', ')', ')', ')'}, {')', '(', ')', '(', ')', ')', ')', ')', '(', '(', '(', '(', ')', '(', ')', '(', '(', '(', '(', '(', ')', '(', '(', ')', ')', '(', '(', '(', ')', '(', ')', ')', '('}, {')', ')', ')', '(', ')', ')', ')', '(', '(', ')', ')', '(', '(', '(', '(', ')', '(', '(', ')', ')', '(', ')', ')', ')', '(', ')', ')', '(', ')', ')', '(', '(', '('}, {')', '(', ')', '(', '(', ')', ')', '(', ')', ')', ')', '(', '(', '(', ')', '(', '(', '(', ')', '(', ')', '(', ')', ')', ')', ')', ')', '(', ')', ')', '(', '(', ')'}, {'(', '(', ')', ')', '(', ')', ')', '(', '(', '(', '(', ')', '(', ')', '(', '(', '(', '(', '(', '(', ')', '(', ')', '(', ')', ')', '(', '(', '(', ')', '(', '(', ')'}, {')', ')', '(', '(', ')', ')', '(', '(', '(', '(', '(', '(', '(', ')', ')', '(', '(', '(', ')', ')', '(', ')', '(', '(', ')', ')', '(', ')', ')', '(', ')', '(', '('}, {')', ')', ')', ')', '(', ')', ')', '(', '(', '(', '(', ')', ')', ')', '(', ')', ')', ')', ')', ')', ')', '(', '(', '(', '(', ')', ')', ')', ')', '(', '(', '(', ')'}}));
    }

    static class Solution {
        public boolean hasValidPath(char[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            if (grid[0][0] == ')' || grid[height - 1][width - 1] == '(') {
                return false;
            }
            int[][] dirs = new int[][]{{1, 0}, {0, 1}};
            boolean[][][] visited = new boolean[height][width][height + width];
            // BFS
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0, 0, grid[0][0] == '(' ? 1 : -1});
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                int currentY = pos[0];
                int currentX = pos[1];
                int currentStatus = pos[2];
                if (currentY == height - 1 && currentX == width - 1 && currentStatus == 0) {
                    return true;
                }

                // 需要使用dirs数组进行循环遍历，不要手动做条件判断，因为在循环遍历过程中使用了continue，手动的话会跳出外面的循环漏数据
                for (int[] dir : dirs) {
                    int nextY = currentY + dir[0];
                    int nextX = currentX + dir[1];
                    if (nextY >= height || nextX >= width) {
                        continue;
                    }
                    int nextStatus = currentStatus + (grid[nextY][nextX] == '(' ? 1 : -1);
                    int[] nextPos = new int[]{nextY, nextX, nextStatus};
                    if (nextStatus < 0 || visited[nextY][nextX][nextStatus]) {
                        continue;
                    }
                    visited[nextY][nextX][nextStatus] = true;
                    queue.add(nextPos);
                }
            }
            return false;
        }
    }

    static class Solution_BFS记忆化 {
        public boolean hasValidPath(char[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            if (grid[0][0] == ')' || grid[height - 1][width - 1] == '(') {
                return false;
            }
            // BFS
            Set<String> posSet = new HashSet<>();
            Queue<Pos> queue = new ArrayDeque<>();
            queue.add(new Pos(0, 0, grid[0][0] == '(' ? 1 : -1));
            while (!queue.isEmpty()) {
                Pos pos = queue.poll();
                int currentY = pos.y;
                int currentX = pos.x;
                int currentStatus = pos.status;
                if (currentY == height - 1 && currentX == width - 1 && currentStatus == 0) {
                    return true;
                }

                // 需要使用dirs数组进行循环遍历，不要手动做条件判断，因为在循环遍历过程中使用了continue，手动的话会跳出外面的循环漏数据
                int[][] dirs = new int[][]{{1, 0}, {0, 1}};
                for (int[] dir : dirs) {
                    int nextY = currentY + dir[0];
                    int nextX = currentX + dir[1];
                    if (nextY >= height || nextX >= width) {
                        continue;
                    }
                    int nextStatus = currentStatus + (grid[nextY][nextX] == '(' ? 1 : -1);
                    Pos nextPos = new Pos(nextY, nextX, nextStatus);
                    if (nextStatus < 0 || posSet.contains(nextPos.toString())) {
                        continue;
                    }
                    posSet.add(nextPos.toString());
                    queue.add(nextPos);
                }
            }
            return false;
        }

        class Pos {
            int y;
            int x;
            int status;

            public Pos(int y, int x, int status) {
                this.y = y;
                this.x = x;
                this.status = status;
            }

            @Override
            public String toString() {
                return y + "," + x + "," + status;
            }
        }
    }

    static class Solution_DFS {
        boolean result = false;
        int stack = 0;

        public boolean hasValidPath(char[][] grid) {
            dfs(grid, 0, 0);
            return result;
        }

        private void dfs(char[][] grid, int y, int x) {
            if (result) {
                return;
            }
            if (y >= grid.length || x >= grid[0].length) {
                return;
            }
            if (y == grid.length - 1 && x == grid[0].length - 1) {
                if (grid[y][x] == ')' && stack == 1) {
                    result = true;
                }
            }
            char current = grid[y][x];
            if (current == '(') {
                stack++;
                dfs(grid, y + 1, x);
                dfs(grid, y, x + 1);
                stack--;
            } else if (current == ')') {
                if (stack <= 0) {
                    return;
                } else {
                    stack--;
                    dfs(grid, y + 1, x);
                    dfs(grid, y, x + 1);
                    stack++;
                }
            }
        }
    }

}
