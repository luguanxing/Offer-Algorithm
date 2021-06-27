package leetcode.contest.week247;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test5798_循环轮转矩阵 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().rotateGrid(new int[][]{
                {40, 10},
                {30, 20}
        }, 1)));
        System.out.println(Arrays.toString(new Solution().rotateGrid(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        }, 2)));
        System.out.println(Arrays.toString(new Solution().rotateGrid(new int[][]{
                {10, 1, 4, 8},
                {6, 6, 3, 10},
                {7, 4, 7, 10},
                {1, 10, 6, 1},
                {2, 1, 1, 10},
                {3, 8, 9, 2},
                {7, 1, 10, 10},
                {7, 1, 4, 9},
                {2, 2, 4, 2},
                {10, 7, 5, 10}
        }, 2)));
    }

    static class Solution {
        public int[][] rotateGrid(int[][] grid, int k) {
            List<List<Integer>> gridList = new ArrayList<>();
            // 压缩矩阵
            int h = grid.length;
            int w = grid[0].length;
            for (int level = 1; level <= Math.min(h / 2, w / 2); level++) {
                // 上、右、下、左
                List<Integer> compact = new ArrayList<>();
                for (int x = level - 1; x <= w - level; x++) {
                    compact.add(grid[level - 1][x]);
                }
                for (int y = level; y <= h - level; y++) {
                    compact.add(grid[y][w - level]);
                }
                for (int x = w - level - 1; x >= level - 1; x--) {
                    compact.add(grid[h - level][x]);
                }
                for (int y = h - level; y > level; y--) {
                    compact.add(grid[y - 1][level - 1]);
                }
                gridList.add(compact);
            }

            // 每层移动k
            for (int i = 0; i < gridList.size(); i++) {
                List<Integer> list = gridList.get(i);
                int move = k % list.size();
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list.subList(move, list.size()));
                newList.addAll(list.subList(0, move));
                gridList.set(i, newList);
            }

            // 重新设置
            for (int level = 1; level <= Math.min(h / 2, w / 2); level++) {
                int cnt = 0;
                // 上、右、下、左
                for (int x = level - 1; x <= w - level; x++) {
                    grid[level - 1][x] = gridList.get(level - 1).get(cnt++);
                }
                for (int y = level; y <= h - level; y++) {
                    grid[y][w - level] = gridList.get(level - 1).get(cnt++);
                }
                for (int x = w - level - 1; x >= level - 1; x--) {
                    grid[h - level][x] = gridList.get(level - 1).get(cnt++);
                }
                for (int y = h - level; y > level; y--) {
                    grid[y - 1][level - 1] = gridList.get(level - 1).get(cnt++);
                }
            }
            return grid;
        }
    }

}
