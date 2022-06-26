package leetcode.contest.week299;

public class Test6101_判断矩阵是否是一个X矩阵 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkXMatrix(new int[][]{
                {2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}
        }));
        System.out.println(new Solution().checkXMatrix(new int[][]{
                {5, 7, 0}, {0, 3, 1}, {0, 5, 0}
        }));
    }

    static class Solution {
        public boolean checkXMatrix(int[][] grid) {
            int n = grid.length;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (isDiagonals(y, x, n)) {
                        if (grid[y][x] == 0) {
                            return false;
                        }
                    } else {
                        if (grid[y][x] != 0) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private boolean isDiagonals(int y, int x, int n) {
            return y == x || y + x == n - 1;
        }
    }

}
