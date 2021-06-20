package leetcode.contest.week246;

import java.util.*;

public class Test5791_统计子岛屿 {

    public static void main(String[] args) {
        System.out.println(new Solution().countSubIslands(
                new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}},
                new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}}
        ));
        System.out.println(new Solution().countSubIslands(
                new int[][]{{1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}},
                new int[][]{{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}}
        ));
        System.out.println(new Solution().countSubIslands(
                new int[][]{{1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1}, {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1}, {1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1}},
                new int[][]{{1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1}, {1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1}, {0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1}, {1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1}, {1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0}, {1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1}, {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1}, {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0}, {1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1}, {1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1}, {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1}, {0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0}}
        ));
    }

    static class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int res = 0;
            for (int y = 0; y < grid2.length; y++) {
                for (int x = 0; x < grid2[0].length; x++) {
                    if (grid2[y][x] == 1) {
                        if (bfsCheck(grid1, grid2, new Pos(y, x))) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
        
        static boolean bfsCheck(int[][] grid1, int[][] grid2, Pos initPos) {
            boolean res = true;
            Queue<Pos> queue = new ArrayDeque<>();
            queue.add(initPos);
            while (!queue.isEmpty()) {
                Pos pos = queue.poll();
                if (grid1[pos.y][pos.x] != 1) {
                    res = false;
                }
                grid2[pos.y][pos.x] = 0;
                for (Pos nextP : pos.getNextPos(grid2.length, grid2[0].length)) {
                    if (grid2[nextP.y][nextP.x] == 1) {
                        queue.add(nextP);
                    }
                }
            }
            return res;
        }

        static class Pos {
            int y;
            int x;

            public Pos(int y, int x) {
                this.y = y;
                this.x = x;
            }

            public List<Pos> getNextPos(int h, int w) {
                List<Pos> list = new ArrayList<>();
                if (0 <= y - 1) {
                    list.add(new Pos(y - 1, x));
                }
                if (0 <= x - 1) {
                    list.add(new Pos(y, x - 1));
                }
                if (y + 1 < h) {
                    list.add(new Pos(y + 1, x));
                }
                if (x + 1 < w) {
                    list.add(new Pos(y, x + 1));
                }
                return list;
            }

            @Override
            public String toString() {
                return y + "," + x;
            }
        }
    }

    static class Solution_暴力 {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            // 标记岛1所有子岛
            int island1Flag = 100;
            for (int y = 0; y < grid1.length; y++) {
                for (int x = 0; x < grid1[0].length; x++) {
                    if (grid1[y][x] == 1) {
                        bfsMarkIsland(grid1, new Pos(y, x), island1Flag);
                        island1Flag++;
                    }
                }
            }
            // 标记岛1所有子岛
            int island2Flag = 10000;
            for (int y = 0; y < grid2.length; y++) {
                for (int x = 0; x < grid2[0].length; x++) {
                    if (grid2[y][x] == 1) {
                        bfsMarkIsland(grid2, new Pos(y, x), island2Flag);
                        island2Flag++;
                    }
                }
            }
            // 检查包含关系
            int res = 0;
            for (int y = 0; y < grid2.length; y++) {
                for (int x = 0; x < grid2[0].length; x++) {
                    if (grid2[y][x] > 0 && grid1[y][x] > 0) {
                        int flag1 = grid1[y][x];
                        int flag2 = grid2[y][x];
                        if (checkContains(grid1, grid2, new Pos(y, x), flag1, flag2)) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }

        static boolean checkContains(int[][] grid1, int[][] grid2, Pos initPos, int flag1, int flag2) {
            boolean res = true;
            Queue<Pos> queue = new ArrayDeque<>();
            Set<String> set = new HashSet<>();
            queue.add(initPos);
            while (!queue.isEmpty()) {
                Pos p = queue.poll();
                if (grid1[p.y][p.x] != flag1) {
                    res = false;
                }
                set.add(p.toString());
                grid2[p.y][p.x] = 0;
                for (Pos nextP : p.getNextPos(grid2.length, grid2[0].length)) {
                    if (!set.contains(nextP.toString()) && grid2[nextP.y][nextP.x] == flag2) {
                        queue.add(nextP);
                    }
                }
            }
            return res;
        }

        static void bfsMarkIsland(int[][] grid, Pos initPos, int flag) {
            Queue<Pos> queue = new ArrayDeque<>();
            Set<String> set = new HashSet<>();
            queue.add(initPos);
            while (!queue.isEmpty()) {
                Pos pos = queue.poll();
                set.add(pos.toString());
                grid[pos.y][pos.x] = flag;
                for (Pos nextP : pos.getNextPos(grid.length, grid[0].length)) {
                    if (grid[nextP.y][nextP.x] == 1 && !set.contains(nextP.toString())) {
                        queue.add(nextP);
                    }
                }
            }
        }

        static class Pos {
            int y;
            int x;

            public Pos(int y, int x) {
                this.y = y;
                this.x = x;
            }

            public List<Pos> getNextPos(int h, int w) {
                List<Pos> list = new ArrayList<>();
                if (0 <= y - 1) {
                    list.add(new Pos(y - 1, x));
                }
                if (0 <= x - 1) {
                    list.add(new Pos(y, x - 1));
                }
                if (y + 1 < h) {
                    list.add(new Pos(y + 1, x));
                }
                if (x + 1 < w) {
                    list.add(new Pos(y, x + 1));
                }
                return list;
            }

            @Override
            public String toString() {
                return y + "," + x;
            }
        }
    }

}
