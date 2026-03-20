package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3567_子矩阵的最小绝对差 {

    public static void main(String[] args) {
        // grid = [[1,8],[3,-2]], k = 2
        for (int[] row : new Solution().minAbsDiff(new int[][]{{1, 8}, {3, -2}}, 2)) {
            System.out.println(Arrays.toString(row));
        }
        //  grid = [[3,-1]], k = 1
        for (int[] row : new Solution().minAbsDiff(new int[][]{{3, -1}}, 1)) {
            System.out.println(Arrays.toString(row));
        }
        // grid = [[1,-2,3],[2,3,5]], k = 2
        for (int[] row : new Solution().minAbsDiff(new int[][]{{1, -2, 3}, {2, 3, 5}}, 2)) {
            System.out.println(Arrays.toString(row));
        }
        // grid = [[44003,96986],[-28220,-59335]], k = 2
        for (int[] row : new Solution().minAbsDiff(new int[][]{{44003, 96986}, {-28220, -59335}}, 2)) {
            System.out.println(Arrays.toString(row));
        }
        // grid = [[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0]], k = 5
        for (int[] row : new Solution().minAbsDiff(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }, 5)) {
            System.out.println(Arrays.toString(row));
        };
    }

    static class Solution {
        public int[][] minAbsDiff(int[][] grid, int k) {
            int height = grid.length;
            int width = grid[0].length;
            int[][] res = new int[height-k+1][width-k+1];
            for (int y = 0; y < res.length; y++) {
                for (int x = 0; x < res[0].length; x++) {
                    List<Integer> list = new ArrayList<>();
                    for (int yy = y; yy < y+k; yy++) {
                        for (int xx = x; xx < x+k; xx++) {
                            list.add(grid[yy][xx]);
                        }
                    }
                    list.sort(Integer::compareTo);
                    int currentMin = Integer.MAX_VALUE;
                    for (int i = 0; i < list.size() - 1; i++) {
                        if (list.get(i).equals(list.get(i+1))) {
                            continue;
                        }
                        currentMin = Math.min(currentMin, Math.abs(list.get(i) - list.get(i + 1)));
                    }
                    res[y][x] = currentMin == Integer.MAX_VALUE ? 0 : currentMin;
                }
            }
            return res;
        }
    }

}
