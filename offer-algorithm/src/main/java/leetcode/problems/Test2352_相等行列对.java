package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test2352_相等行列对 {

    public static void main(String[] args) {
        System.out.println(new Solution().equalPairs(
                new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}
        ));
        System.out.println(new Solution().equalPairs(
                new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}
        ));
    }

    static class Solution {
        public int equalPairs(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            Map<String, Integer> rowMap = new HashMap<>();
            Map<String, Integer> colMap = new HashMap<>();
            for (int[] row : grid) {
                String rowStr = Arrays.toString(row);
                rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
            }
            for (int x = 0; x < width; x++) {
                int[] col = new int[height];
                for (int y = 0; y < height; y++) {
                    col[y] = grid[y][x];
                }
                String colStr = Arrays.toString(col);
                colMap.put(colStr, colMap.getOrDefault(colStr, 0) + 1);
            }
            int res = 0;
            for (String rowStr : rowMap.keySet()) {
                int rowCnt = rowMap.get(rowStr);
                int colCnt = colMap.getOrDefault(rowStr, 0);
                res += rowCnt * colCnt;
            }
            return res;
        }
    }

}
