package leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test1030_距离顺序排列矩阵单元格 {

    public static void main(String[] args) {
        int[][] res1 = new Solution().allCellsDistOrder(1, 2, 0, 0);
        for (int[] yx : res1) {
            System.out.print(yx[0] + "-" + yx[1] + "\t");
        }
        System.out.println();
        int[][] res2 = new Solution().allCellsDistOrder(2, 2, 0, 1);
        for (int[] yx : res2) {
            System.out.print(yx[0] + "-" + yx[1] + "\t");
        }
        System.out.println();
        int[][] res3 = new Solution().allCellsDistOrder(2, 3, 1, 2);
        for (int[] yx : res3) {
            System.out.print(yx[0] + "-" + yx[1] + "\t");
        }
    }

    static class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            List<Cell> list = new ArrayList<>();
            for (int y = 0; y < R; y++) {
                for (int x = 0; x < C; x++) {
                    Cell cell = new Cell(y, x, Math.abs(y - r0) + Math.abs(x - c0));
                    list.add(cell);
                }
            }
            list.sort(Comparator.comparingInt(o -> o.distance));
            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i][0] = list.get(i).col;
                res[i][1] = list.get(i).row;
            }
            return res;
        }

        class Cell {
            int col;
            int row;
            int distance;

            public Cell(int col, int row, int distance) {
                this.col = col;
                this.row = row;
                this.distance = distance;
            }
        }
    }

}
