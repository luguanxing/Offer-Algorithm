package leetcode.contest.week436;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test100562_按对角线进行矩阵排序 {

    public static void main(String[] args) {
        // grid = [[1,7,3],[9,8,2],[4,5,6]]
        int[][] res1 = new Solution().sortMatrix(new int[][]{{1, 7, 3}, {9, 8, 2}, {4, 5, 6}});
        for (int[] row : res1) {
            System.out.println(Arrays.toString(row));
        }
        // grid = [[0,1],[1,2]]
        int[][] res2 = new Solution().sortMatrix(new int[][]{{0, 1}, {1, 2}});
        for (int[] row : res2) {
            System.out.println(Arrays.toString(row));
        }
        //  grid = [[1]]
        int[][] res3 = new Solution().sortMatrix(new int[][]{{1}});
        for (int[] row : res3) {
            System.out.println(Arrays.toString(row));
        }
    }

    static class Solution {
        public int[][] sortMatrix(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            // 右上部分按递增排序
            for (int x = 1; x < width; x++) {
                sortD(grid, true, 0, x, height, width);
            }
            // 左下部分按递增排序
            for (int y = 0; y < height; y++) {
                sortD(grid, false, y, 0, height, width);
            }
            return grid;
        }

        private void sortD(int[][] grid, boolean asc, int y, int x, int height, int width) {
            List<Integer> list = new ArrayList<>();
            int yy = y;
            int xx = x;
            while (yy < height && xx < width) {
                list.add(grid[yy][xx]);
                yy++;
                xx++;
            }
            if (asc) {
                Collections.sort(list);
            } else {
                Collections.sort(list, Collections.reverseOrder());
            }
            yy = y;
            xx = x;
            for (int i = 0; i < list.size(); i++) {
                grid[yy][xx] = list.get(i);
                yy++;
                xx++;
            }
        }
    }

}
