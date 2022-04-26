package leetcode.problems;

public class Test0883_三维形体投影面积 {

    public static void main(String[] args) {
        System.out.println(new Solution().projectionArea(new int[][]{
                {1, 2}, {3, 4}
        }));
        System.out.println(new Solution().projectionArea(new int[][]{
                {2}
        }));
        System.out.println(new Solution().projectionArea(new int[][]{
                {1, 0}, {0, 2}
        }));
    }

    static class Solution {
        public int projectionArea(int[][] grid) {
            int top = 0;
            int front = 0;
            int right = 0;
            for (int[] topCnts : grid) {
                for (int topCnt : topCnts) {
                    if (topCnt > 0) {
                        top++;
                    }
                }
            }
            int length = grid.length;
            int width = grid[0].length;
            for (int x = 0; x < width; x++) {
                int maxColCnt = grid[0][x];
                for (int y = 1; y < length; y++) {
                    maxColCnt = Math.max(maxColCnt, grid[y][x]);
                }
                front += maxColCnt;
            }
            for (int y = 0; y < length; y++) {
                int maxRowCnt = grid[y][0];
                for (int x = 1; x < width; x++) {
                    maxRowCnt = Math.max(maxRowCnt, grid[y][x]);
                }
                right += maxRowCnt;
            }
            return top + front + right;
        }
    }

}
