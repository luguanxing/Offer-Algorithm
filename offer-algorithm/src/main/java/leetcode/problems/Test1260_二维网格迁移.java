package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1260_二维网格迁移 {

    public static void main(String[] args) {
        System.out.println(new Solution().shiftGrid(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1
        ));
        System.out.println(new Solution().shiftGrid(
                new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}, 4
        ));
        System.out.println(new Solution().shiftGrid(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9
        ));
    }

    static class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int height = grid.length;
            int width = grid[0].length;
            List<List<Integer>> cols = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                List<Integer> col = new ArrayList<>();
                for (int y = 0; y < height; y++) {
                    col.add(grid[y][x]);
                }
                cols.add(col);
            }
            for (int i = 1; i <= k; i++) {
                shift(cols);
            }
            List<List<Integer>> res = new ArrayList<>();
            for (int y = 0; y < height; y++) {
                List<Integer> row = new ArrayList<>();
                for (int x = 0; x < width; x++) {
                    row.add(cols.get(x).get(y));
                }
                res.add(row);
            }
            return res;
        }

        private void shift(List<List<Integer>> cols) {
            int len = cols.size();
            List<Integer> lastCol = cols.get(len - 1);
            cols.remove(len - 1);

            int colSize = lastCol.size();
            int lastNum = lastCol.get(colSize - 1);
            lastCol.remove(colSize - 1);
            lastCol.add(0, lastNum);

            cols.add(0, lastCol);
        }
    }

}
