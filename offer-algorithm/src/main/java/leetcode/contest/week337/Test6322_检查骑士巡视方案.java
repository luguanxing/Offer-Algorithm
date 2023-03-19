package leetcode.contest.week337;

import java.util.TreeMap;

public class Test6322_检查骑士巡视方案 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidGrid(new int[][]{{0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}}));
        System.out.println(new Solution().checkValidGrid(new int[][]{{0, 3, 6}, {5, 8, 1}, {2, 7, 4}}));
    }

    static class Solution {
        public boolean checkValidGrid(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            TreeMap<Integer, int[]> map = new TreeMap<>();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int idx = grid[y][x];
                    map.put(idx, new int[]{y, x});
                }
            }
            int y = 0;
            int x = 0;
            for (int i = 1; i < height * width; i++) {
                int nextY = map.get(i)[0];
                int nextX = map.get(i)[1];
                if (!isValid(y, x, nextY, nextX)) {
                    return false;
                }
                y = nextY;
                x = nextX;
            }
            return true;
        }

        private boolean isValid(int y, int x, int nextY, int nextX) {
            return (Math.abs(y - nextY) == 1 && Math.abs(x - nextX) == 2) ||
                    (Math.abs(y - nextY) == 2 && Math.abs(x - nextX) == 1);
        }
    }

}
