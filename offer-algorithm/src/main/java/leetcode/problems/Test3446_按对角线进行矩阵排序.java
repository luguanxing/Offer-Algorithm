package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test3446_按对角线进行矩阵排序 {

    public static void main(String[] args) {
        // grid = [[1,7,3],[9,8,2],[4,5,6]]
        int[][] solution1 = new Solution().sortMatrix(new int[][]{
                {1, 7, 3},
                {9, 8, 2},
                {4, 5, 6}
        });
        for (int[] row : solution1) {
            System.out.println(Arrays.toString(row));
        }
        // grid = [[0,1],[1,2]]
        int[][] solution2 = new Solution().sortMatrix(new int[][]{
                {0, 1},
                {1, 2}
        });
        for (int[] row : solution2) {
            System.out.println(Arrays.toString(row));
        }
    }

    static class Solution {
        public int[][] sortMatrix(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            // 按对角线排序
            for (int x = width - 1; x > 0; x--) {
                sortDiagonal(grid, 0, x, height, width, true);
            }
            for (int y = 0; y < height; y++) {
                sortDiagonal(grid, y, 0, height, width, false);
            }
            return grid;
        }

        private void sortDiagonal(int[][] grid, int y, int x, int height, int width, boolean asc) {
            List<Integer> list = new ArrayList<>();
            int startY = y;
            int startX = x;
            while (y < height && x < width) {
                list.add(grid[y][x]);
                y++;
                x++;
            }
            if (asc) {
                Collections.sort(list);
            } else {
                Collections.sort(list, Collections.reverseOrder());
            }
            for (int val : list) {
                grid[startY][startX] = val;
                startY++;
                startX++;
            }
        }
    }

}
