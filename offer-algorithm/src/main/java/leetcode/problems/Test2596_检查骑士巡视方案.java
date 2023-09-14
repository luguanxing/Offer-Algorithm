package leetcode.problems;

import java.util.*;

public class Test2596_检查骑士巡视方案 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidGrid(new int[][]{
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}
        }));
        System.out.println(new Solution().checkValidGrid(new int[][]{
                {0, 3, 6},
                {5, 8, 1},
                {2, 7, 4}
        }));
    }

    static class Solution {
        public boolean checkValidGrid(int[][] grid) {
            Map<Integer, int[]> map = new HashMap<>();
            int n = grid.length;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    int idx = grid[y][x];
                    map.put(idx, new int[]{y, x});
                }
            }
            if (map.get(0)[0] != 0 || map.get(0)[1] != 0) {
                return false;
            }
            int y = 0;
            int x = 0;
            for (int idx = 1; idx < n * n; idx++) {
                int[] yx = map.get(idx);
                int nextY = yx[0];
                int nextX = yx[1];
                if (Math.abs(nextX - x) * Math.abs(nextY - y) == 2) {
                    y = nextY;
                    x = nextX;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
