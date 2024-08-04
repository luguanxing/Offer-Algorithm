package leetcode.contest.week409;

import java.util.HashMap;
import java.util.Map;

public class Q1_设计相邻元素求和服务 {

    public static void main(String[] args) {
        // [[0, 1, 2], [3, 4, 5], [6, 7, 8]]]
        neighborSum n1 = new neighborSum(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        System.out.println(n1.adjacentSum(1));
        System.out.println(n1.adjacentSum(4));
        System.out.println(n1.diagonalSum(4));
        System.out.println(n1.diagonalSum(8));
        // [[1, 2, 0, 3], [4, 7, 15, 6], [8, 9, 10, 11], [12, 13, 14, 5]]]
        neighborSum n2 = new neighborSum(new int[][]{{1, 2, 0, 3}, {4, 7, 15, 6}, {8, 9, 10, 11}, {12, 13, 14, 5}});
        System.out.println(n2.adjacentSum(15));
        System.out.println(n2.diagonalSum(9));
    }

    static class neighborSum {
        int[][] grid;
        int len;
        Map<Integer, int[]> map = new HashMap<>();

        public neighborSum(int[][] grid) {
            this.grid = grid;
            len = grid.length;
            for (int y = 0; y < len; y++) {
                for (int x = 0; x < len; x++) {
                    map.put(grid[y][x], new int[]{y, x});
                }
            }
        }

        public int adjacentSum(int value) {
            int sum = 0;
            int y = map.get(value)[0];
            int x = map.get(value)[1];
            if (y - 1 >= 0) {
                sum += grid[y - 1][x];
            }
            if (y + 1 < len) {
                sum += grid[y + 1][x];
            }
            if (x - 1 >= 0) {
                sum += grid[y][x - 1];
            }
            if (x + 1 < len) {
                sum += grid[y][x + 1];
            }
            return sum;
        }

        public int diagonalSum(int value) {
            int sum = 0;
            int y = map.get(value)[0];
            int x = map.get(value)[1];
            if (y - 1 >= 0 && x - 1 >= 0) {
                sum += grid[y - 1][x - 1];
            }
            if (y - 1 >= 0 && x + 1 < len) {
                sum += grid[y - 1][x + 1];
            }
            if (y + 1 < len && x - 1 >= 0) {
                sum += grid[y + 1][x - 1];
            }
            if (y + 1 < len && x + 1 < len) {
                sum += grid[y + 1][x + 1];
            }
            return sum;
        }
    }


}
