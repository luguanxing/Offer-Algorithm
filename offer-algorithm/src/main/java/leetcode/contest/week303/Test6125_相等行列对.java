package leetcode.contest.week303;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test6125_相等行列对 {

    public static void main(String[] args) {
        System.out.println(new Solution().equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        System.out.println(new Solution().equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
    }

    static class Solution {
        public int equalPairs(int[][] grid) {
            // 存储行
            Map<String, Integer> rowMap = new HashMap<>();
            for (int[] row : grid) {
                String rowStr = Arrays.toString(row);
                rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
            }
            // 枚举列
            int res = 0;
            int n = grid.length;
            for (int x = 0; x < n; x++) {
                int[] col = new int[n];
                for (int y = 0; y < n; y++) {
                    col[y] = grid[y][x];
                }
                String colStr = Arrays.toString(col);
                res += rowMap.getOrDefault(colStr, 0);
            }
            return res;
        }
    }

}
