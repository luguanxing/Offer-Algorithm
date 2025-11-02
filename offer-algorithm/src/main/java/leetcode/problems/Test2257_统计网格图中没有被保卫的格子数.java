package leetcode.problems;

public class Test2257_统计网格图中没有被保卫的格子数 {

    public static void main(String[] args) {
        // m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
        System.out.println(new Solution().countUnguarded(4, 6,
                new int[][]{{0, 0}, {1, 1}, {2, 3}},
                new int[][]{{0, 1}, {2, 2}, {1, 4}})
        );
        // m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
        System.out.println(new Solution().countUnguarded(3, 3,
                new int[][]{{1, 1}},
                new int[][]{{0, 1}, {1, 0}, {2, 1}, {1, 2}})
        );
    }

    static class Solution {
        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            int[][] grid = new int[m][n];
            // 标记墙壁和守卫
            for (int[] wall : walls) {
                grid[wall[0]][wall[1]] = 2;
            }
            for (int[] guard : guards) {
                grid[guard[0]][guard[1]] = 1;
            }
            // 标记守卫和被守卫保卫的格子
            for (int[] guard : guards) {
                int x = guard[0];
                int y = guard[1];
                // 向上标记
                for (int i = x - 1; i >= 0; i--) {
                    if (grid[i][y] == 2 || grid[i][y] == 1) {
                        break;
                    }
                    grid[i][y] = 3;
                }
                // 向下标记
                for (int i = x + 1; i < m; i++) {
                    if (grid[i][y] == 2 || grid[i][y] == 1) {
                        break;
                    }
                    grid[i][y] = 3;
                }
                // 向左标记
                for (int j = y - 1; j >= 0; j--) {
                    if (grid[x][j] == 2 || grid[x][j] == 1) {
                        break;
                    }
                    grid[x][j] = 3;
                }
                // 向右标记
                for (int j = y + 1; j < n; j++) {
                    if (grid[x][j] == 2 || grid[x][j] == 1) {
                        break;
                    }
                    grid[x][j] = 3;
                }
            }
            // 统计没有被保卫的格子数
            int res = 0;
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (grid[y][x] == 0) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
