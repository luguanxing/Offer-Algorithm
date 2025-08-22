package leetcode.problems;

import java.util.Arrays;

public class Test3195_包含所有1的最小矩形面积I {

    public static void main(String[] args) {
        // grid = [[0,1,0],[1,0,1]]
        System.out.println(new Solution().minimumArea(new int[][]{{0, 1, 0}, {1, 0, 1}}));
        // grid = [[0,0],[1,0]]
        System.out.println(new Solution().minimumArea(new int[][]{{0, 0}, {1, 0}}));
    }

    static class Solution {
        public int minimumArea(int[][] grid) {
            // 找每个行和列首次和末尾出现1的位置
            int height = grid.length;
            int width = grid[0].length;
            int colMin = height, colMax = 0, rowMin = width, rowMax = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 1) {
                        colMin = Math.min(colMin, y);
                        colMax = Math.max(colMax, y);
                        rowMin = Math.min(rowMin, x);
                        rowMax = Math.max(rowMax, x);
                    }
                }
            }
            // 计算矩形面积
            return  (colMax - colMin + 1) * (rowMax - rowMin + 1);
        }
    }

    static class Solution_OLD {
        public int minimumArea(int[][] grid) {
            // 找每个行和列首次和末尾出现1的位置
            int height = grid.length;
            int width = grid[0].length;
            int colMin = -1, colMax = -1;
            for (int y = 0; y < height; y++) {
                int[] row = grid[y];
                int colSum = Arrays.stream(row).sum();
                if (colSum > 0) {
                    if (colMin == -1) {
                        colMin = y;
                    }
                    colMax = y;
                }
            }
            int rowMin = -1, rowMax = -1;
            for (int x = 0; x < width; x++) {
                int colSum = 0;
                for (int y = 0; y < height; y++) {
                    colSum += grid[y][x];
                }
                if (colSum > 0) {
                    if (rowMin == -1) {
                        rowMin = x;
                    }
                    rowMax = x;
                }
            }
            // 计算矩形面积
            if (colMin == -1 || rowMin == -1) {
                return 0;
            }
            return (colMax - colMin + 1) * (rowMax - rowMin + 1);
        }
    }

}
